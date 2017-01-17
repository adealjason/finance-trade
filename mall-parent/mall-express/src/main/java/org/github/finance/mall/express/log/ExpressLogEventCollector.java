package org.github.finance.mall.express.log;

import org.github.finance.common.logevent.BasicDataCollectorSemantics;
import org.github.finance.common.logevent.DataCollector.DataCollectorOut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午2:48:25
 */
@Slf4j
@Component("expressLogEventCollector")
public class ExpressLogEventCollector extends BasicDataCollectorSemantics implements DataCollectorOut {

    @Override
    public void sysoutMetaData(String metaData) {
        log.warn(metaData);
    }

    @Override
    public DataCollectorOut getDataCollectorOut() {
        return this;
    }

}
