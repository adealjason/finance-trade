package org.github.finance.mall.collector.service;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ligaofeng 2017年1月26日 下午6:05:15
 */
public interface IMallCacheService extends Serializable {

    /**
     * 缓存数据
     * 
     * @param key
     * @param value
     */
    public void cache(String key, BigDecimal value);
}
