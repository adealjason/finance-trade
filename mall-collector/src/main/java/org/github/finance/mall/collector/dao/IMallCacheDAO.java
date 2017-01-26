package org.github.finance.mall.collector.dao;

import java.io.Serializable;

import org.github.finance.mall.collector.dao.entity.MallCacheEntity;

/**
 * @author ligaofeng 2017年1月26日 下午7:00:11
 */
public interface IMallCacheDAO extends Serializable {

    public static final String insert_mall_cache = "insert into mall_cache(cache_key,cache_value) values(?,?)";

    public static final String update_mall_cache = "update mall_cache set cache_value=cache_value + ? where cache_key=?";

    /**
     * @param mallCacheEntity
     */
    public void insert(MallCacheEntity mallCacheEntity);

    /**
     * @param mallCacheEntity
     */
    public void update(MallCacheEntity mallCacheEntity);

}
