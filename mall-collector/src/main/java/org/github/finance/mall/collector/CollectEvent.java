package org.github.finance.mall.collector;

import org.github.finance.mall.collector.logevent.convert.MallRegisterEventConvert;

import lombok.Getter;

/**
 * 收集事件列表
 * 
 * @author ligaofeng 2017年1月20日 上午11:01:03
 */
public enum CollectEvent {

    REGISTER("register-stream", MallRegisterEventConvert.class),

    LOGIN("", null),

    LOGOUT("", null),

    BIND_CARD("", null),

    UNBIND("", null),

    CREATE_EXPRESS("", null),

    CREATE_ORDER("", null),

    CREATE_PAYMENT("", null),

    PRE_SALE("", null),

    SOLD("", null);

    @Getter
    private String streamId;
    @Getter
    private Class  eventConvert;

    private CollectEvent(String streamId, Class eventConvert) {
        this.streamId = streamId;
        this.eventConvert = eventConvert;
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
