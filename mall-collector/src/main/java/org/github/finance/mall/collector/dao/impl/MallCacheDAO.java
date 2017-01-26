package org.github.finance.mall.collector.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.github.finance.mall.collector.dao.IMallCacheDAO;
import org.github.finance.mall.collector.dao.PersistenceManager;
import org.github.finance.mall.collector.dao.entity.MallCacheEntity;
import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 * @author ligaofeng 2017年1月26日 下午7:02:29
 */
public class MallCacheDAO implements IMallCacheDAO {

    @Override
    public void insert(final MallCacheEntity mallCacheEntity) {
        PersistenceManager.getInstance().getJdbcTemplate().update(insert_mall_cache, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, mallCacheEntity.getCacheKey());
                ps.setBigDecimal(2, mallCacheEntity.getCacheValue());
            }
        });
    }

    @Override
    public void update(final MallCacheEntity mallCacheEntity) {
        PersistenceManager.getInstance().getJdbcTemplate().update(update_mall_cache, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setBigDecimal(1, mallCacheEntity.getCacheValue());
                ps.setString(2, mallCacheEntity.getCacheKey());
            }
        });
    }

}
