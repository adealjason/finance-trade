package org.github.finance.mall.collector.dao.entity;

import java.math.BigDecimal;

/**
 * @author ligaofeng 2017年1月26日 下午6:04:17
 */
public class MallCacheEntity {

    private String     cacheKey;

    private BigDecimal cacheValue;

    /**
     * @return
     */
    public String getCacheKey() {
        return cacheKey;
    }

    /**
     * @param cacheKey
     */
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey == null ? null : cacheKey.trim();
    }

    /**
     * @return
     */
    public BigDecimal getCacheValue() {
        return cacheValue;
    }

    /**
     * @param cacheValue
     */
    public void setCacheValue(BigDecimal cacheValue) {
        this.cacheValue = cacheValue;
    }
}
