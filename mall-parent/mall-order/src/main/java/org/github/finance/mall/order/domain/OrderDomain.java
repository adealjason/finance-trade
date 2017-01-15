package org.github.finance.mall.order.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.github.finance.mall.express.domain.ExpressDomain;
import org.github.finance.mall.payment.domain.PaymentDomain;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:42:47
 */
@Data
public class OrderDomain {

    private String                   orderId;

    private int                      orderProductSize;

    private BigDecimal               orderAmout;

    private String                   expressAmount;

    private String                   currency;

    private String                   status;

    private Date                     outTime;

    private List<OrderProductDomain> orderProductDomainList;

    private PaymentDomain            paymentDomain;

    private ExpressDomain            expressDomain;

}
