package org.github.finance.mall.collector.logevent;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.collector.BaseLogEvent;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月26日 下午12:48:26
 */
@Data
public class CreateOrderEvent extends BaseLogEvent {

    private static final long serialVersionUID = 3757079967615985453L;

    private String            userId;

    private String            userPhone;

    private String            orderId;

    private BigDecimal        orderAmount;

    private int               orderProductSize;

    private Date              applyPurchaseDate;
}
