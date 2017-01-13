package org.github.finance.mall.payment.inner.way;

import org.github.finance.mall.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay.ApplyPaymentRequest;

/**
 * @author ligaofeng 2017年1月13日 下午1:50:31
 */
public class ApplyPaymentRequestHelper {

    private ApplyPaymentRequestHelper() {
    }

    /**
     * @param applyPaymentDTO
     * @return
     */
    public static ApplyPaymentRequest toApplyPaymentRequest(ApplyPaymentDTO applyPaymentDTO) {
        ApplyPaymentRequest applyPaymentRequest = new ApplyPaymentRequest();
        applyPaymentRequest.setApplyPaymentTime(applyPaymentDTO.getApplyPaymentTime());
        applyPaymentRequest.setPaymentId(applyPaymentDTO.getPaymentId());
        applyPaymentRequest.setPaymentAmount(applyPaymentDTO.getPaymentAmount());
        applyPaymentRequest.setPaymentWay(applyPaymentDTO.getPaymentWay());
        applyPaymentRequest.setProductOfferingCode(applyPaymentDTO.getProductOfferingCode());
        applyPaymentRequest.setUserId(applyPaymentDTO.getUserId());
        return applyPaymentRequest;
    }
}
