package org.github.finance.mall.payment.inner;

import org.github.finance.mall.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.inner.impl.PaymentHandlerTemplate.PaymentResult;

/**
 * @author ligaofeng 2017年1月13日 下午1:13:57
 */
public interface IPaymentHandler {

    /**
     * @param applyPaymentDTO
     * @return
     * @throws MallPaymentException
     */
    public PaymentResult applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException;
}
