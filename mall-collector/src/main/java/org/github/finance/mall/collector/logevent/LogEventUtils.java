package org.github.finance.mall.collector.logevent;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.github.finance.mall.collector.CollectEvent;
import org.github.finance.mall.collector.ILogEventConvert;

import com.google.common.collect.Maps;

/**
 * @author ligaofeng 2017年1月21日 上午9:45:21
 */
public class LogEventUtils {

    private static Map<String, ILogEventConvert> logEventConvertors = Maps.newHashMap();

    private static Map<String, String>           logEventSteams     = Maps.newHashMap();

    static {
        initConvertors();
        initStreams();
    }

    public static String getStreamId(String logEvent) {
        return logEventSteams.isEmpty() ? null : logEventSteams.get(logEvent);
    }

    /**
     * @param logEvent
     * @return
     */
    public synchronized static ILogEventConvert getLogEventConvert(String logEvent) {
        if (logEventConvertors.isEmpty() || !logEventConvertors.containsKey(logEvent)) {
            return null;
        }
        return logEventConvertors.get(logEvent);
    }

    private synchronized static void initConvertors() {
        for (CollectEvent an : CollectEvent.values()) {
            if (an.getEventConvert() == null) {
                throw new RuntimeException("--->请指定" + an.name() + "的转换器");
            }
            try {
                ILogEventConvert instance = (ILogEventConvert) an.getEventConvert().newInstance();
                logEventConvertors.put(an.name(), instance);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void initStreams() {
        for (CollectEvent an : CollectEvent.values()) {
            if (StringUtils.isNotEmpty(an.getStreamId())) {
                logEventSteams.put(an.name(), an.getStreamId());
            }
        }
    }
}
