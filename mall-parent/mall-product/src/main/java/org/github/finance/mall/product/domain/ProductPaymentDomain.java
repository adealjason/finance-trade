package org.github.finance.mall.product.domain;

import org.github.finance.mall.share.payment.constance.PaymentWayEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:09:19
 */
@Data
public class ProductPaymentDomain {

    private String         productPayentId;

    private String         productOfferingCode;

    private PaymentWayEnum paymentWay;

    private String         status;

}
