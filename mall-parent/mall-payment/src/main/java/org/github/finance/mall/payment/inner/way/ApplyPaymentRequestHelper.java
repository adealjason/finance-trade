package org.github.finance.mall.payment.inner.way;

import org.github.finance.mall.payment.domain.PaymentDomain;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay.ApplyPaymentRequest;

/**
 * @author ligaofeng 2017年1月13日 下午1:50:31
 */
public class ApplyPaymentRequestHelper {

    private ApplyPaymentRequestHelper() {
    }

    /**
     * @param paymentDomain
     * @return
     */
    public static ApplyPaymentRequest toApplyPaymentRequest(PaymentDomain paymentDomain) {
        ApplyPaymentRequest applyPaymentRequest = new ApplyPaymentRequest();
        applyPaymentRequest.setApplyPaymentTime(paymentDomain.getApplyPaymentTime());
        applyPaymentRequest.setPaymentId(paymentDomain.getPaymentRequestId());
        applyPaymentRequest.setPaymentAmount(paymentDomain.getPaymentAmount());
        applyPaymentRequest.setPaymentWay(paymentDomain.getPaymentWay());
        applyPaymentRequest.setProductOfferingCode(paymentDomain.getProductOfferingCode());
        applyPaymentRequest.setUserId(paymentDomain.getUserId());
        return applyPaymentRequest;
    }
}
