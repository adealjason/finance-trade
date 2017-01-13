package org.github.finance.mall.payment.inner.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.github.finance.mall.NotNull;
import org.github.finance.mall.payment.SpringHolder;
import org.github.finance.mall.payment.constance.PaymentStatusEnum;
import org.github.finance.mall.payment.constance.PaymentWayEnum;
import org.github.finance.mall.payment.dao.dataobject.PaymentRequestDO;
import org.github.finance.mall.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.inner.IPaymentHandler;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay.ApplyPaymentRequest;
import org.github.finance.mall.payment.inner.way.ApplyPaymentRequestHelper;
import org.github.finance.mall.payment.service.IPaymentRequestService;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月13日 下午1:17:12
 */
@Slf4j
@Service
public class PaymentHandler implements IPaymentHandler {

    @Resource
    private IPaymentRequestService paymentRequestService;

    @Override
    public PaymentWay.PaymentResult applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException {
        PaymentWay.PaymentResult paymentResult = new PaymentWay.PaymentResult();
        PaymentRequestDO paymentRequestDO = this.checkPaymentId(applyPaymentDTO.getPaymentId());
        try {
            ApplyPaymentRequest applyPaymentRequest = ApplyPaymentRequestHelper.toApplyPaymentRequest(applyPaymentDTO);

            log.info("--->execute payment:{}", applyPaymentRequest);

            this.turnPaymentStatus(paymentRequestDO, PaymentStatusEnum.PAYMENT_PROCESS);

            PaymentWay paymentWay = this.getPaymentWay(applyPaymentDTO.getPaymentWay());

            paymentResult = paymentWay.applyPayment(applyPaymentRequest);

            this.turnPaymentStatus(paymentRequestDO, PaymentStatusEnum.PAYMENT_SUCCESS);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            paymentResult.setResult(false);
            paymentResult.setMessage(e.getMessage());
            this.turnPaymentStatus(paymentRequestDO, PaymentStatusEnum.PAYMENT_FAIL);
        }

        return paymentResult;
    }

    private void turnPaymentStatus(PaymentRequestDO paymentRequestDO, PaymentStatusEnum paymentStatus)
            throws MallPaymentException {
        paymentRequestDO.setPaymentStatus(paymentStatus.name());
        paymentRequestService.updatePaymentRequest(paymentRequestDO);
    }

    private PaymentRequestDO checkPaymentId(String paymentId) throws MallPaymentException {
        PaymentRequestDO paymentRequestDO = paymentRequestService.loadPaymentRequestDO(paymentId);

        if (paymentRequestDO == null) {
            throw new MallPaymentException("待支付订单不存在:" + paymentId);
        }
        return paymentRequestDO;
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
         * @param applyPaymentRequest
         * @return
         * @throws MallPaymentException
         */
        public PaymentResult applyPayment(ApplyPaymentRequest applyPaymentRequest) throws MallPaymentException;

        /**
         * @author ligaofeng 2017年1月13日 下午1:22:18
         */
        @Data
        public class PaymentResult {
            @NotNull
            private String  paymentId;

            @NotNull
            private boolean result;

            private String  message;
        }

        /**
         * @author ligaofeng 2017年1月13日 下午1:48:28
         */
        @NotNull
        @Data
        public class ApplyPaymentRequest {

            private String         paymentId;

            private String         userId;

            private String         productOfferingCode;

            private BigDecimal     paymentAmount;

            private Date           applyPaymentTime;

            private PaymentWayEnum paymentWay;
        }
    }

}
