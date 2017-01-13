package org.github.finance.mall.payment;

import org.github.finance.mall.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.payment.exception.MallPaymentException;

/**
 * @author ligaofeng 2017年1月13日 下午12:48:27
 */
public interface IPaymentService {

    /**
     * @param applyPaymentDTO
     * @throws MallPaymentException
     */
    public void applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException;

}
