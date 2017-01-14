package org.github.finance.mall.share.payment.dto;

import java.math.BigDecimal;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午3:11:38
 */
@NotNull
@Data
public class CreatePaymentDTO {

    private String     userId;

    private String     orderId;

    private String     productOfferingCode;

    private BigDecimal paymentAmount;

}
