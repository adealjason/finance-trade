package org.github.finance.mall.storehouse.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.share.storeHouse.constance.StoreHouseLogEvent;
import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
import org.github.finance.mall.share.storeHouse.dto.SoldDTO;
import org.github.finance.mall.storehouse.IStoreHourseService;
import org.github.finance.mall.storehouse.exception.MallStoreHouseException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午2:02:01
 */
@Slf4j
@Service
public class StoreHourseService implements IStoreHourseService {

    @Resource(name = "storeLogEventCollector")
    private DataCollector storeLogEventCollector;

    @Override
    public void preSale(final PreSaleDTO preSaleDTO) throws MallStoreHouseException {
        log.info("--->pre sale:{}", preSaleDTO);

        storeLogEventCollector.collectData(new DataCollectorProvider() {
            @Override
            public Map<String, String> getMetaData() {
                Map<String, String> dataMap = Maps.newHashMap();
                dataMap.put("userId", preSaleDTO.getUserId());
                dataMap.put("orderId", preSaleDTO.getOrderId());
                dataMap.put("productOfferingCode", preSaleDTO.getProductOfferingCode());
                dataMap.put("size", String.valueOf(preSaleDTO.getSize()));
                dataMap.put("applyPurchaseDate", String.valueOf(preSaleDTO.getApplyPurchaseDate().getTime()));
                return dataMap;
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
            public Map<String, String> getMetaData() {
                Map<String, String> dataMap = Maps.newHashMap();
                dataMap.put("preSaleId", soldDTO.getPreSaleId());
                dataMap.put("paymentAmount", soldDTO.getPaymentAmount().toString());
                dataMap.put("paymentSuccessDate", String.valueOf(soldDTO.getPaymentSuccessDate().getTime()));
                return dataMap;
            }

            @Override
            public String getLogEvent() {
                return StoreHouseLogEvent.SOLE.name();
            }
        });
    }

}
