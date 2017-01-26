package org.github.finance.mall.collector.dao;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import lombok.Getter;
import lombok.ToString;

/**
 * @author ligaofeng 2017年1月26日 下午6:33:04
 */
@ToString
public class PersistenceManager implements Serializable {
    private static final long               serialVersionUID   = 1834014104625989597L;

    private DataSource                      dataSource;
    @Getter
    private JdbcTemplate                    jdbcTemplate;
    @Getter
    private TransactionTemplate             transactionTemplate;
    private static final PersistenceManager persistenceManager = new PersistenceManager();

    public static PersistenceManager getInstance() {
        return persistenceManager;
    }

    private PersistenceManager() {
        try {
            Properties pro = this.loadProperties();
            dataSource = DruidDataSourceFactory.createDataSource(pro);
            jdbcTemplate = new JdbcTemplate(dataSource);
            transactionTemplate = new TransactionTemplate(new DataSourceTransactionManager(dataSource));
            transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Properties loadProperties() throws Exception {
        InputStream ins = PersistenceManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(ins);
        ins.close();
        return pro;
    }

}
