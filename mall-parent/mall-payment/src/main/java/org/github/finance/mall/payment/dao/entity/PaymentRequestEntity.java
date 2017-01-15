package org.github.finance.mall.payment.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午1:59:24
 */
@Data
public class PaymentRequestEntity {

    @NotNull
    private String     id;

    @NotNull
    private String     userId;

    @NotNull
    private String     orderId;

    @NotNull
    private String     productOfferingCode;

    @NotNull
    private BigDecimal paymentAmount;

    @NotNull
    private String     paymentStatus;

    private Date       applyPaymentTime;

    private String     paymentWay;

    @NotNull
    private String     isDeleted;

    @NotNull
    private String     creator;

    @NotNull
    private String     modifier;

    @NotNull
    private Date       gmtCreated;

    @NotNull
    private Date       gmtModified;
}
