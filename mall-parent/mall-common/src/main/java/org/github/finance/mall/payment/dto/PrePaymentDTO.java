package org.github.finance.mall.payment.dto;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午12:57:17
 */
@Data
public class PrePaymentDTO {

    private String userId;

    private String orderId;

    private String productOfferingCode;

    private String paymentAmount;

}
