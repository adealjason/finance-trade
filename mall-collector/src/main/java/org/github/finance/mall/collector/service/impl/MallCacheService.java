package org.github.finance.mall.collector.service.impl;

import java.math.BigDecimal;

import org.github.finance.mall.collector.dao.IMallCacheDAO;
import org.github.finance.mall.collector.dao.PersistenceManager;
import org.github.finance.mall.collector.dao.entity.MallCacheEntity;
import org.github.finance.mall.collector.dao.impl.MallCacheDAO;
import org.github.finance.mall.collector.service.IMallCacheService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月26日 下午6:06:24
 */
@Slf4j
public class MallCacheService implements IMallCacheService {

    private final IMallCacheDAO mallCacheDAO;

    public MallCacheService() {
        mallCacheDAO = new MallCacheDAO();
    }

    @Override
    public void cache(String key, BigDecimal value) {
        final MallCacheEntity mallCacheEntity = new MallCacheEntity();
        mallCacheEntity.setCacheKey(key);
        mallCacheEntity.setCacheValue(value);
        PersistenceManager.getInstance().getTransactionTemplate().execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    saveOrUpdate(mallCacheEntity);
                } catch (Exception e) {
                    status.setRollbackOnly();
                    log.error(e.getMessage(), e);
                }
            }
        });
    }

    private void saveOrUpdate(MallCacheEntity mallCacheEntity) throws Exception {
        try {
            mallCacheDAO.insert(mallCacheEntity);
        } catch (Exception e) {
            try {
                mallCacheDAO.update(mallCacheEntity);
            } catch (Exception ex) {
                throw ex;
            }
        }
    }

}
