package org.github.finance.mall.share.payment.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.NotNull;
import org.github.finance.mall.share.payment.constance.PaymentWayEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午12:57:17
 */
@NotNull
@Data
public class ApplyPaymentDTO {

    private String         userId;

    private String         paymentId;

    private String         productOfferingCode;

    private BigDecimal     paymentAmount;

    private Date           applyPaymentTime;

    private PaymentWayEnum paymentWay;

}
