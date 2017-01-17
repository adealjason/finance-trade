package org.github.finance.mall.payment.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.payment.constance.PaymentStatusEnum;
import org.github.finance.mall.share.payment.constance.PaymentWayEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午9:39:10
 */
@Data
public class PaymentDomain {

    private String            paymentRequestId;

    private String            userId;

    private String            orderId;

    private BigDecimal        paymentAmount;

    private PaymentStatusEnum paymentStatus;

    private Date              applyPaymentTime;

    private PaymentWayEnum    paymentWay;

}
