package org.github.finance.mall.share.payment.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午3:11:38
 */
@NotNull
@Data
public class CreatePaymentDTO implements Serializable {

    private static final long serialVersionUID = -7918166138879008676L;

    private String            userId;

    private String            orderId;

    private String            productOfferingCode;

    private BigDecimal        paymentAmount;

}
