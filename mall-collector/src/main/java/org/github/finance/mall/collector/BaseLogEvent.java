package org.github.finance.mall.collector;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月20日 下午6:38:16
 */
@Data
public class BaseLogEvent implements Serializable {

    private static final long   serialVersionUID = -9037075367655600887L;

    private CollectEvent        collectEvent;

    private Map<String, Object> otherData;
}
