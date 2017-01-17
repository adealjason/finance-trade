package org.github.finance.mall.account.log;

import org.github.finance.common.logevent.BasicDataCollectorSemantics;
import org.github.finance.common.logevent.DataCollector.DataCollectorOut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午2:45:09
 */
@Slf4j
@Component("userAccountLogEventCollector")
public class UserAccountLogEventCollector extends BasicDataCollectorSemantics implements DataCollectorOut {

    @Override
    public void sysoutMetaData(String metaData) {
        log.warn(metaData);
    }

    @Override
    public DataCollectorOut getDataCollectorOut() {
        return this;
    }

}
