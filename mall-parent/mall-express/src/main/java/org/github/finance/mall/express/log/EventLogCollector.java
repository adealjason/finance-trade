package org.github.finance.mall.express.log;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午2:48:25
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
