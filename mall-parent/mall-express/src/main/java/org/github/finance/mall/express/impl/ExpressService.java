package org.github.finance.mall.express.impl;

import java.util.List;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.express.IExpressService;
import org.github.finance.mall.express.domain.ExpressDomain;
import org.github.finance.mall.express.domain.helper.ExpressDomainHelper;
import org.github.finance.mall.express.exception.MallExpressException;
import org.github.finance.mall.share.express.constance.ExpressLogEvent;
import org.github.finance.mall.share.express.dto.CreateExpressDTO;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午1:18:41
 */
@Slf4j
@Service
public class ExpressService implements IExpressService {

    @Resource(name = "expressLogEventCollector")
    private DataCollector expressLogEventCollector;

    @Override
    public void createExpress(final CreateExpressDTO createExpressDTO) throws MallExpressException {
        log.info("--->will create express:{}", createExpressDTO);
        ExpressDomain expressDomain = ExpressDomainHelper.toExpressDomain(createExpressDTO);

        expressLogEventCollector.collectData(new DataCollectorProvider() {

            @Override
            public List<String> getMetaData() {
                List<String> dataList = Lists.newArrayListWithCapacity(5);
                dataList.add(createExpressDTO.getUserId());
                dataList.add(createExpressDTO.getOrderId());
                dataList.add(createExpressDTO.getUserPhone());
                dataList.add(createExpressDTO.getExpressProviderId());
                dataList.add(String.valueOf(DateTime.now().toDate().getTime()));
                return dataList;
            }

            @Override
            public String getLogEvent() {
                return ExpressLogEvent.CREATE_EXPRESS.name();
            }
        });
    }

}
