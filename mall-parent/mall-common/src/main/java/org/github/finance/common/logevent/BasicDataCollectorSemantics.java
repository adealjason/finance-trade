package org.github.finance.common.logevent;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

/**
 * @author ligaofeng 2017年1月17日 下午1:27:35
 */
public class BasicDataCollectorSemantics implements DataCollector {

    @Override
    public String collectData(DataCollectorProvider dataProvider) {
        StringBuilder sbd = new StringBuilder();
        String logEvent = dataProvider.getLogEvent();
        Collection<String> data = dataProvider.getMetaData().values();
        String dataStr = StringUtils.join(data, ",");
        sbd.append(logEvent).append(":").append(dataStr);
        return sbd.toString();
    }

}
