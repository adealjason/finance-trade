package org.github.finance.mall.order.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:43:46
 */
@Data
public class OrderProductDomain {

    private String     orderProductId;

    private String     orderId;

    private String     productOfferingCode;

    private String     productName;

    private int        productSize;

    //折扣比例
    private BigDecimal discountRate;

    private BigDecimal sumAmount;

    private String     currency;
}
