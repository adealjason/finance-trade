package org.github.finance.common.logevent;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

/**
 * @author ligaofeng 2017年1月17日 下午1:27:35
 */
public abstract class BasicDataCollectorSemantics implements DataCollector {

    @Override
    public void collectData(DataCollectorProvider dataProvider) {
        DataCollectorOut dataCollectorOut = this.getDataCollectorOut();
        StringBuilder sbd = new StringBuilder();
        String logEvent = dataProvider.getLogEvent();
        Collection<String> data = dataProvider.getMetaData().values();
        String dataStr = StringUtils.join(data, ",");
        sbd.append(logEvent).append(":").append(dataStr);
        dataCollectorOut.sysoutMetaData(sbd.toString());
    }

}
