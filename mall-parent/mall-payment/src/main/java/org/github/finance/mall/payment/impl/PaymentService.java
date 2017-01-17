package org.github.finance.mall.payment.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.payment.IPaymentService;
import org.github.finance.mall.payment.domain.PaymentDomain;
import org.github.finance.mall.payment.domain.helper.PaymentDomainHelper;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.inner.IPaymentHandler;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay;
import org.github.finance.mall.payment.service.IPaymentRequestService;
import org.github.finance.mall.share.payment.constance.PaymentLogEvent;
import org.github.finance.mall.share.payment.constance.PaymentStatusEnum;
import org.github.finance.mall.share.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.share.payment.dto.CreatePaymentDTO;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月13日 下午1:12:56
 */
@Slf4j
@Service
public class PaymentService implements IPaymentService {

    @Resource
    private IPaymentRequestService paymentRequestService;
    @Resource
    private IPaymentHandler        paymentHandler;
    @Resource(name = "paymentLogEventCollector")
    private DataCollector          paymentLogEventCollector;

    @Override
    public String createPayment(final CreatePaymentDTO createPaymentDTO) throws MallPaymentException {
        log.info("--->user {} create a payment,amount:{}", createPaymentDTO.getUserId(),
                createPaymentDTO.getPaymentAmount());
        PaymentDomain paymentDomain = PaymentDomainHelper.toPaymentDomain(createPaymentDTO);
        this.assembleCreatePayment(paymentDomain);
        final String paymentId = paymentRequestService.savePaymentRequest(paymentDomain);

        paymentLogEventCollector.collectData(new DataCollectorProvider() {

            @Override
            public Map<String, String> getMetaData() {
                Map<String, String> dataMap = Maps.newHashMap();
                dataMap.put("userId", createPaymentDTO.getUserId());
                dataMap.put("orderId", createPaymentDTO.getOrderId());
                dataMap.put("paymentId", paymentId);
                dataMap.put("paymentAmount", createPaymentDTO.getPaymentAmount().toString());
                dataMap.put("applyPaymentTime", String.valueOf(createPaymentDTO.getApplyPaymentTime().getTime()));
                return dataMap;
            }

            @Override
            public String getLogEvent() {
                return PaymentLogEvent.CREATE_PAYMENT.name();
            }
        });
        return paymentId;
    }

    private void assembleCreatePayment(PaymentDomain paymentDomain) {
        paymentDomain.setPaymentStatus(PaymentStatusEnum.PAYMENT_WAIT);
    }

    @Override
    public PaymentWay.PaymentResult applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException {
        log.info("--->user {} apply payment:{}", applyPaymentDTO.getUserId(), applyPaymentDTO);
        PaymentDomain paymentDomain = PaymentDomainHelper.toPaymentDomain(applyPaymentDTO);
        return paymentHandler.applyPayment(paymentDomain);
    }

}
