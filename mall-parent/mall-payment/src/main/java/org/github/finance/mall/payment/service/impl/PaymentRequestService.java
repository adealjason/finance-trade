package org.github.finance.mall.payment.service.impl;

import java.math.BigDecimal;

import org.github.finance.mall.payment.constance.PaymentStatusEnum;
import org.github.finance.mall.payment.constance.PaymentWayEnum;
import org.github.finance.mall.payment.dao.dataobject.PaymentRequestDO;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.service.IPaymentRequestService;
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
    public String savePaymentRequest(PaymentRequestDO paymentRequestDO) throws MallPaymentException {
        log.info("--->check params not null...");

        String paymentId = PaymentIdGenerator.generatePaymentId();
        paymentRequestDO.setId(paymentId);
        log.info("--->save the paymentRequestDO:{}", paymentRequestDO);

        return paymentId;
    }

    @Override
    public void updatePaymentRequest(PaymentRequestDO paymentRequestDO) throws MallPaymentException {
        log.info("--->check params not null...");

        log.info("--->save the paymentRequestDO:{}", paymentRequestDO);
    }

    /**
     * @author ligaofeng 2017年1月13日 下午1:52:59
     */
    public static class PaymentIdGenerator {

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
    public PaymentRequestDO loadPaymentRequestDO(String paymentId) throws MallPaymentException {
        PaymentRequestDO paymentRequestDO = new PaymentRequestDO();
        paymentRequestDO.setId("12345678");
        paymentRequestDO.setApplyPaymentTime(DateTime.now().withTimeAtStartOfDay().plusHours(10).toDate());
        paymentRequestDO.setCreator("system");
        paymentRequestDO.setGmtCreated(DateTime.now().withTimeAtStartOfDay().plusHours(10).toDate());
        paymentRequestDO.setGmtModified(DateTime.now().withTimeAtStartOfDay().plusHours(10).toDate());
        paymentRequestDO.setIsDeleted("N");
        paymentRequestDO.setOrderId("12345678");
        paymentRequestDO.setPaymentAmount(new BigDecimal("129.19"));
        paymentRequestDO.setPaymentStatus(PaymentStatusEnum.PAYMENT_WAIT.name());
        paymentRequestDO.setPaymentWay(PaymentWayEnum.CHINA_PAY.name());
        paymentRequestDO.setProductOfferingCode("12345678");
        paymentRequestDO.setUserId("12345678");
        return paymentRequestDO;
    }

}
