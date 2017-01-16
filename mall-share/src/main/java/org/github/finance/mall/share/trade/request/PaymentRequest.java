package org.github.finance.mall.share.trade.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.payment.constance.PaymentWayEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月16日 下午1:09:47
 */
@Data
public class PaymentRequest implements Serializable {

    private static final long serialVersionUID = -5995808404703866896L;

    private String            userId;

    private String            orderId;

    private String            paymentRequestId;

    private String            productOfferingCode;

    private BigDecimal        paymentAmount;

    private Date              applyPaymentTime;

    private PaymentWayEnum    paymentWay;
}
