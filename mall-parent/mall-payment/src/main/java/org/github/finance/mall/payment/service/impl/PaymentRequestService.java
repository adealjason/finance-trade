package org.github.finance.mall.payment.service.impl;

import java.math.BigDecimal;

import org.github.finance.mall.payment.dao.entity.PaymentRequestEntity;
import org.github.finance.mall.payment.dao.helper.PaymentRequestEntityHelper;
import org.github.finance.mall.payment.domain.PaymentDomain;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.service.IPaymentRequestService;
import org.github.finance.mall.share.payment.constance.PaymentStatusEnum;
import org.github.finance.mall.share.payment.constance.PaymentWayEnum;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月13日 下午2:02:24
 */
@Slf4j
@Service
public class PaymentRequestService implements IPaymentRequestService {

    @Override
    public String savePaymentRequest(PaymentDomain paymentDomain) throws MallPaymentException {
        log.info("--->check params not null...");
        PaymentRequestEntity paymentRequestEntity = PaymentRequestEntityHelper
                .toCreatePaymentRequestEntity(paymentDomain);
        String paymentId = PaymentIdGenerator.generatePaymentId();
        paymentRequestEntity.setId(paymentId);
        log.info("--->save the paymentRequestEntity:{}", paymentRequestEntity);

        return paymentId;
    }

    @Override
    public void updatePaymentRequest(PaymentDomain paymentDomain) throws MallPaymentException {
        log.info("--->check params not null...");

        log.info("--->save the paymentDomain:{}", paymentDomain);
    }

    /**
     * @author ligaofeng 2017年1月13日 下午1:52:59
     */
    private static class PaymentIdGenerator {

        private PaymentIdGenerator() {
        }

        /**
         * @return
         */
        public static String generatePaymentId() {
            return String.valueOf((int) ((Math.random() * 9 + 1) * 100000000));
        }
    }

    @Override
    public PaymentDomain loadPaymentRequestDomain(String paymentId) throws MallPaymentException {
        PaymentDomain paymentDomain = new PaymentDomain();
        paymentDomain.setPaymentRequestId("12345678");
        paymentDomain.setApplyPaymentTime(DateTime.now().withTimeAtStartOfDay().plusHours(10).toDate());
        paymentDomain.setOrderId("12345678");
        paymentDomain.setPaymentAmount(new BigDecimal("129.19"));
        paymentDomain.setPaymentStatus(PaymentStatusEnum.PAYMENT_WAIT);
        paymentDomain.setPaymentWay(PaymentWayEnum.CHINA_PAY);
        paymentDomain.setProductOfferingCode("12345678");
        paymentDomain.setUserId("12345678");
        return paymentDomain;
    }

}
