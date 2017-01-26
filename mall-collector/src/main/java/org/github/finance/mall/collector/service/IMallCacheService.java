package org.github.finance.mall.collector.service;

/**
 * @author ligaofeng 2017年1月26日 下午6:05:15
 */
public interface IMallCacheService {

    /**
     * 缓存数据
     * 
     * @param key
     * @param value
     */
    public void cache(String key, String value);
}
