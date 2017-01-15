package org.github.finance.mall.payment.domain.helper;

import org.github.finance.mall.payment.domain.PaymentDomain;
import org.github.finance.mall.share.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.share.payment.dto.CreatePaymentDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author ligaofeng 2017年1月15日 下午12:11:35
 */
public class PaymentDomainHelper {

    private PaymentDomainHelper() {
    }

    /**
     * @param createPaymentDTO
     * @return
     */
    public static PaymentDomain toPaymentDomain(CreatePaymentDTO createPaymentDTO) {
        PaymentDomain paymentDomain = new PaymentDomain();
        BeanUtils.copyProperties(createPaymentDTO, paymentDomain);
        return paymentDomain;
    }

    /**
     * @param applyPaymentDTO
     * @return
     */
    public static PaymentDomain toPaymentDomain(ApplyPaymentDTO applyPaymentDTO) {
        PaymentDomain paymentDomain = new PaymentDomain();
        BeanUtils.copyProperties(applyPaymentDTO, paymentDomain);
        return paymentDomain;
    }
}
