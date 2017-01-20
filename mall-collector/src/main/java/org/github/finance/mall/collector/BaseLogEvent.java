package org.github.finance.mall.collector;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月20日 上午10:58:41
 */
@Data
public class BaseLogEvent implements Serializable {

    private static final long                   serialVersionUID = 4367832182898017935L;

    private CollectEvent                        collectEvent;

    private Map<String, ? extends Serializable> otherData;

}
