package org.github.finance.common.logevent;

import java.util.List;

/**
 * @author ligaofeng 2017年1月17日 下午1:16:45
 */
public interface DataCollector {

    /**
     * @return
     */
    public DataCollectorOut getDataCollectorOut();

    /**
     * @param dataProvider
     * @return
     */
    public void collectData(DataCollectorProvider dataProvider);

    /**
     * @author ligaofeng 2017年1月17日 下午1:30:57
     */
    public interface DataCollectorOut {

        /**
         * @param metaData
         */
        public void sysoutMetaData(String metaData);
    }

    /**
     * @author ligaofeng 2017年1月17日 下午1:17:27
     */
    public interface DataCollectorProvider {

        /**
         * 日志事件
         * 
         * @return
         */
        public String getLogEvent();

        /**
         * 元数据
         * 
         * @return
         */
        public List<String> getMetaData();
    }
}
