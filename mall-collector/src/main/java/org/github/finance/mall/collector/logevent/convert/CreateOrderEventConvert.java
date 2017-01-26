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
        createOrderEvent.setOrderId(otherDatas[1]);
        createOrderEvent.setOrderAmount(new BigDecimal(otherDatas[2]));
        createOrderEvent.setOrderProductSize(Integer.valueOf(otherDatas[3]));
        Long time = Long.valueOf(otherDatas[4]);
        createOrderEvent.setApplyPurchaseDate(new Date(time));
    }

    @Override
    protected BaseLogEvent getLogEvent() {
        return new CreateOrderEvent();
    }

}
