package org.github.finance.mall.express.impl;

import java.util.Map;

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

import com.google.common.collect.Maps;

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
            public Map<String, String> getMetaData() {
                Map<String, String> dataMap = Maps.newHashMap();
                dataMap.put("userId", createExpressDTO.getUserId());
                dataMap.put("orderId", createExpressDTO.getOrderId());
                dataMap.put("userPhone", createExpressDTO.getUserPhone());
                dataMap.put("expressProviderId", createExpressDTO.getExpressProviderId());
                dataMap.put("createExpressDate", String.valueOf(DateTime.now().toDate().getTime()));
                return dataMap;
            }

            @Override
            public String getLogEvent() {
                return ExpressLogEvent.CREATE_EXPRESS.name();
            }
        });
    }

}
