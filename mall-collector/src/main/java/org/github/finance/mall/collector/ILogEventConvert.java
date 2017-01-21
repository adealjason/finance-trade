package org.github.finance.mall.collector;

/**
 * @author ligaofeng 2017年1月20日 下午6:11:30
 */
public interface ILogEventConvert {

    /**
     * @param record
     * @return
     */
    public BaseLogEvent convert(String record);

    /**
     * @author ligaofeng 2017年1月20日 下午7:25:18
     */
    public interface EventDataAssemble {

        /**
         * @param baseLogEvent
         * @param otherData
         */
        public void assembleData(BaseLogEvent baseLogEvent, String otherData);
    }

}
