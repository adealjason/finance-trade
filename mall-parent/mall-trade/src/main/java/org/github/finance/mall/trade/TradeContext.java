package org.github.finance.mall.trade;

import java.util.HashMap;
import java.util.Map;

import org.github.finance.mall.product.dao.entity.ProductDefinitionEntity;
import org.github.finance.mall.product.dao.entity.ProductOfferingEntity;
import org.github.finance.mall.share.trade.EventObject;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Transcation上下文
 * 
 * @author ligaofeng 2017年1月15日 下午8:14:16
 */
@Component
@Data
public class TradeContext {

    private static final ThreadLocal<TradeContext> LOCAL         = new ThreadLocal<TradeContext>() {
                                                                     @Override
                                                                     protected TradeContext initialValue() {
                                                                         return new TradeContext();
                                                                     }
                                                                 };

    private EventObject                            eventObject;

    private ProductDefinitionEntity                productDefinitionEntity;

    private ProductOfferingEntity                  productOfferingEntity;

    /** 仅允许存储请求参数的key-value */
    private final Map<String, Object>              paramsMap     = new HashMap<String, Object>();

    private String                                 transactionId = "-1";

    private TransactionEnum                 transactionService;

    private TradeContext() {

    }

    /**
     * 放入值
     * 
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        LOCAL.get().getParamsMap().put(key, value);
    }

    /**
     * 获取对应值
     * 
     * @param key
     * @return
     */
    public Object get(String key) {
        return LOCAL.get().getParamsMap().get(key);
    }

    /**
     * 单例初始化
     * 
     * @return
     */
    public static TradeContext getInstance() {
        return LOCAL.get();
    }

    /**
     * 获取事件对象
     * 
     * @param requiredType
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getEventObject(Class<T> requiredType) {
        return (T) eventObject;
    }

    /**
     * 清除事件
     */
    public void clear() {
        LOCAL.get().getParamsMap().clear();
        LOCAL.remove();
    }
}
