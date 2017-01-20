package org.github.finance.mall.storehouse.impl;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.share.storeHouse.constance.StoreHouseLogEvent;
import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
import org.github.finance.mall.share.storeHouse.dto.SoldDTO;
import org.github.finance.mall.storehouse.IStoreHourseService;
import org.github.finance.mall.storehouse.exception.MallStoreHouseException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午2:02:01
 */
@Slf4j
@Service
public class StoreHourseService implements IStoreHourseService {

    @Resource(name = "storeLogEventCollector")
    private DataCollector                           storeLogEventCollector;

    private static final ThreadLocal<DecimalFormat> local = new ThreadLocal<DecimalFormat>() {

                                                              @Override
                                                              protected DecimalFormat initialValue() {
                                                                  super.initialValue();
                                                                  return new DecimalFormat("#0.00");
                                                              }
                                                          };

    @Override
    public void preSale(final PreSaleDTO preSaleDTO) throws MallStoreHouseException {
        log.info("--->pre sale:{}", preSaleDTO);

        storeLogEventCollector.collectData(new DataCollectorProvider() {
            @Override
            public List<String> getMetaData() {
                List<String> dataList = Lists.newArrayListWithCapacity(5);
                dataList.add(preSaleDTO.getUserId());
                dataList.add(preSaleDTO.getOrderId());
                dataList.add(preSaleDTO.getProductOfferingCode());
                dataList.add(String.valueOf(preSaleDTO.getSize()));
                dataList.add(String.valueOf(preSaleDTO.getApplyPurchaseDate().getTime()));
                return dataList;
            }

            @Override
            public String getLogEvent() {
                return StoreHouseLogEvent.PRE_SALE.name();
            }
        });
    }

    @Override
    public void sold(final SoldDTO soldDTO) throws MallStoreHouseException {
        log.info("--->product sold:{}", soldDTO);

        storeLogEventCollector.collectData(new DataCollectorProvider() {

            @Override
            public List<String> getMetaData() {
                List<String> dataList = Lists.newArrayListWithCapacity(3);
                dataList.add(soldDTO.getPreSaleId());
                dataList.add(local.get().format(soldDTO.getPaymentAmount()));
                dataList.add(String.valueOf(soldDTO.getPaymentSuccessDate().getTime()));
                return dataList;
            }

            @Override
            public String getLogEvent() {
                return StoreHouseLogEvent.SOLD.name();
            }
        });
    }

}
