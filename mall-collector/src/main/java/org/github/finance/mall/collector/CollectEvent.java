package org.github.finance.mall.collector;

import org.apache.commons.lang.StringUtils;
import org.github.finance.mall.collector.logevent.CreateOrderEvent;
import org.github.finance.mall.collector.logevent.MallRegisterEvent;
import org.github.finance.mall.collector.logevent.convert.CreateOrderEventConvert;
import org.github.finance.mall.collector.logevent.convert.MallRegisterEventConvert;

import lombok.Getter;

/**
 * 收集事件列表
 * 
 * @author ligaofeng 2017年1月20日 上午11:01:03
 */
public enum CollectEvent {

    REGISTER("register-stream", MallRegisterEventConvert.class, MallRegisterEvent.class.getSimpleName()),

    LOGIN("", null, null),

    LOGOUT("", null, null),

    BIND_CARD("", null, null),

    UNBIND("", null, null),

    CREATE_EXPRESS("", null, null),

    CREATE_ORDER("createOrder-stream", CreateOrderEventConvert.class, CreateOrderEvent.class.getSimpleName()),

    CREATE_PAYMENT("", null, null),

    PRE_SALE("", null, null),

    SOLD("", null, null);

    @Getter
    private String streamId;
    @Getter
    private Class  eventConvert;
    @Getter
    private String eventName;

    private CollectEvent(String streamId, Class eventConvert, String eventName) {
        this.streamId = streamId;
        this.eventConvert = eventConvert;
        this.eventName = eventName;
    }

    /**
     * @param an
     * @return
     */
    public static boolean check(CollectEvent an) {
        return StringUtils.isNotEmpty(an.getStreamId()) && an.getEventConvert() != null
                && StringUtils.isNotEmpty(an.getEventName());
    }

    /**
     * 是否包含某个事件
     * 
     * @param event
     * @return
     */
    public static boolean contains(String event) {
        for (CollectEvent an : CollectEvent.values()) {
            if (an.name().equals(event)) {
                return true;
            }
        }
        return false;
    }

}
