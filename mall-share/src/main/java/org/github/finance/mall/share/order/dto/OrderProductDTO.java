package org.github.finance.mall.share.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午7:41:45
 */
@Data
public class OrderProductDTO implements Serializable {

    private static final long serialVersionUID = -7193155354737396078L;

    private String            productOfferingCode;

    private String            productName;

    private int               productSize;

    //折扣比例
    private BigDecimal        discountRate;

    private BigDecimal        unitPrice;

    private String            currency;
}
