package org.github.finance.mall.collector.logevent.convert;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.collector.BaseLogEvent;
import org.github.finance.mall.collector.BasicLogEventConvertSemantics;
import org.github.finance.mall.collector.logevent.CreateOrderEvent;

import com.alibaba.druid.util.StringUtils;

/**
 * @author ligaofeng 2017年1月26日 下午12:47:05
 */
public class CreateOrderEventConvert extends BasicLogEventConvertSemantics {

    @Override
    public void assembleData(BaseLogEvent baseLogEvent, String otherData) {
        if (StringUtils.isEmpty(otherData)) {
            return;
        }
        CreateOrderEvent createOrderEvent = (CreateOrderEvent) baseLogEvent;
        String[] otherDatas = otherData.split(",");
        createOrderEvent.setUserId(otherDatas[0]);
        createOrderEvent.setUserPhone(otherDatas[1]);
        createOrderEvent.setOrderId(otherDatas[2]);
        createOrderEvent.setOrderAmount(new BigDecimal(otherDatas[3]));
        createOrderEvent.setOrderProductSize(Integer.valueOf(otherDatas[4]));
        Long time = Long.valueOf(otherDatas[5]);
        createOrderEvent.setApplyPurchaseDate(new Date(time));
    }

    @Override
    protected BaseLogEvent getLogEvent() {
        return new CreateOrderEvent();
    }

}
