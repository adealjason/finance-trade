package org.github.finance.mall.share.trade;

import java.io.Serializable;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午8:25:58
 */
@Data
public class EventObject implements Serializable {

    private static final long serialVersionUID = 8530909415061296635L;

    private String            eventId;

    private String            transaction;

}
