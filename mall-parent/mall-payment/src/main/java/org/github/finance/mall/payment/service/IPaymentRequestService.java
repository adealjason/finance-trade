package org.github.finance.mall.payment.service;

import org.github.finance.mall.payment.dao.dataobject.PaymentRequestDO;
import org.github.finance.mall.payment.exception.MallPaymentException;

/**
 * @author ligaofeng 2017年1月13日 下午1:58:55
 */
public interface IPaymentRequestService {

    /**
     * @param paymentRequestDO
     * @return
     * @throws MallPaymentException
     */
    public String savePaymentRequest(PaymentRequestDO paymentRequestDO) throws MallPaymentException;

    /**
     * @param paymentRequestDO
     * @throws MallPaymentException
     */
    public void updatePaymentRequest(PaymentRequestDO paymentRequestDO) throws MallPaymentException;

    /**
     * @param paymentId
     * @return
     * @throws MallPaymentException
     */
    public PaymentRequestDO loadPaymentRequestDO(String paymentId) throws MallPaymentException;
}
