package org.github.finance.mall.payment.service;

import org.github.finance.mall.payment.domain.PaymentDomain;
import org.github.finance.mall.payment.exception.MallPaymentException;

/**
 * @author ligaofeng 2017年1月13日 下午1:58:55
 */
public interface IPaymentRequestService {

    /**
     * @param paymentDomain
     * @return
     * @throws MallPaymentException
     */
    public String savePaymentRequest(PaymentDomain paymentDomain) throws MallPaymentException;

    /**
     * @param paymentDomain
     * @throws MallPaymentException
     */
    public void updatePaymentRequest(PaymentDomain paymentDomain) throws MallPaymentException;

    /**
     * @param paymentId
     * @return
     * @throws MallPaymentException
     */
    public PaymentDomain loadPaymentRequestDomain(String paymentId) throws MallPaymentException;
}
