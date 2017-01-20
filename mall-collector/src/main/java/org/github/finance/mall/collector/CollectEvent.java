package org.github.finance.mall.collector;

/**
 * 收集事件列表
 * 
 * @author ligaofeng 2017年1月20日 上午11:01:03
 */
public enum CollectEvent {

    REGISTER,

    LOGIN,

    LOGOUT,

    BIND_CARD,

    UNBIND,

    CREATE_EXPRESS,

    CREATE_ORDER,

    CREATE_PAYMENT,

    PRE_SALE,

    SOLD;

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
