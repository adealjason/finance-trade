package org.github.finance.mall.payment.dao.helper;

import org.github.finance.mall.payment.dao.entity.PaymentRequestEntity;
import org.github.finance.mall.payment.domain.PaymentDomain;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月13日 下午2:05:03
 */
public class PaymentRequestEntityHelper {

    private PaymentRequestEntityHelper() {
    }

    /**
     * @param paymentDomain
     * @return
     */
    public static PaymentRequestEntity toCreatePaymentRequestEntity(PaymentDomain paymentDomain) {
        DateTime now = DateTime.now();
        PaymentRequestEntity paymentRequestEntity = new PaymentRequestEntity();
        paymentRequestEntity.setIsDeleted("N");
        paymentRequestEntity.setModifier("system");
        paymentRequestEntity.setCreator("system");
        paymentRequestEntity.setGmtCreated(now.toDate());
        paymentRequestEntity.setGmtModified(now.toDate());
        paymentRequestEntity.setOrderId(paymentDomain.getOrderId());
        paymentRequestEntity.setPaymentAmount(paymentDomain.getPaymentAmount());
        paymentRequestEntity.setUserId(paymentDomain.getUserId());
        paymentRequestEntity.setPaymentStatus(paymentDomain.getPaymentStatus().name());
        return paymentRequestEntity;
    }

}
