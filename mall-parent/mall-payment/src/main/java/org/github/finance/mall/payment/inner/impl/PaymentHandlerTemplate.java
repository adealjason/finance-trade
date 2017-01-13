package org.github.finance.mall.payment.inner.impl;

import org.github.finance.mall.payment.SpringHolder;
import org.github.finance.mall.payment.constance.PaymentWayEnum;
import org.github.finance.mall.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.inner.IPaymentHandler;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月13日 下午1:17:12
 */
@Slf4j
@Service
public class PaymentHandlerTemplate implements IPaymentHandler {

    @Override
    public PaymentResult applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException {
        PaymentResult paymentResult = new PaymentResult();
        try {
            log.info("--->check params not null...");
            PaymentWay paymentWay = this.getPaymentWay(applyPaymentDTO.getPaymentWay());

            log.info("--->save the paymentDO...");

            log.info("--->execute payment");
            paymentResult = paymentWay.applyPayment(applyPaymentDTO);

            log.info("--->update payment result");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            paymentResult.setResult(false);
            paymentResult.setMessage(e.getMessage());
        }

        return paymentResult;

    }

    private PaymentWay getPaymentWay(PaymentWayEnum paymentWay) throws MallPaymentException {
        PaymentWay appointPaymentWay = SpringHolder.getBean(paymentWay.getBeanId(), PaymentWay.class);
        if (appointPaymentWay == null) {
            throw new MallPaymentException("无效支付通道:" + paymentWay.name());
        }
        return appointPaymentWay;
    }

    /**
     * @author ligaofeng 2017年1月13日 下午1:26:15
     */
    public interface PaymentWay {

        /**
         * @param applyPaymentDTO
         * @return
         * @throws MallPaymentException
         */
        public PaymentResult applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException;
    }

    /**
     * @author ligaofeng 2017年1月13日 下午1:22:18
     */
    @Data
    public class PaymentResult {
        private String  paymentId;

        private boolean result;

        private String  message;
    }

}
