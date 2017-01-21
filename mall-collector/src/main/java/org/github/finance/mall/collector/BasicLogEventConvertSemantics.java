package org.github.finance.mall.collector;

import org.github.finance.mall.collector.ILogEventConvert.EventDataAssemble;

/**
 * @author ligaofeng 2017年1月20日 下午7:18:42
 */
public abstract class BasicLogEventConvertSemantics implements ILogEventConvert, EventDataAssemble {

    @Override
    public BaseLogEvent convert(String record) {
        String[] records = record.split(":");
        String event = records[0];
        BaseLogEvent baseLogEvent = this.getLogEvent();
        CollectEvent collectEvent = CollectEvent.valueOf(event);
        baseLogEvent.setCollectEvent(collectEvent);
        this.assembleData(baseLogEvent, records[1]);
        return baseLogEvent;
    }

    protected abstract BaseLogEvent getLogEvent();

}
