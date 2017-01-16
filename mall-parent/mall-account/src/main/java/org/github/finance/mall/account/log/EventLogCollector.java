package org.github.finance.mall.account.log;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午2:45:09
 */
@Slf4j
public class EventLogCollector {

    private EventLogCollector() {
    }

    /**
     * 采集日志
     * 
     * @param eventLog
     */
    public static void collect(String eventLog) {
        log.warn(eventLog);
    }
}
