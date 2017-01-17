package org.github.finance.mall.share.payment.dto;

import java.io.Serializable;
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
public class ApplyPaymentDTO implements Serializable {

    private static final long serialVersionUID = 4910811436892726662L;

    private String            userId;

    private String            orderId;

    private String            paymentRequestId;

    private BigDecimal        paymentAmount;

    private Date              applyPaymentTime;

    private PaymentWayEnum    paymentWay;

}
