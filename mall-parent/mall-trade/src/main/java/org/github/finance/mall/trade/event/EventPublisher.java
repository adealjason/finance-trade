package org.github.finance.mall.trade.event;

import org.github.finance.mall.share.trade.EventObject;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午8:29:11
 */
@Slf4j
@Component
public class EventPublisher {

    /**
     * @param eventObject
     */
    public void publishAysnEvent(EventObject eventObject) {
        log.info("--->ready to publishEvent:{}", eventObject);
    }
}
