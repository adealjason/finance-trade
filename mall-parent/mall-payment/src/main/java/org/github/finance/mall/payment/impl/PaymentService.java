package org.github.finance.mall.payment.impl;

import javax.annotation.Resource;

import org.github.finance.mall.payment.IPaymentService;
import org.github.finance.mall.payment.dao.dataobject.PaymentRequestDO;
import org.github.finance.mall.payment.dao.helper.PaymentRequestDOHelper;
import org.github.finance.mall.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.payment.dto.CreatePaymentDTO;
import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.inner.IPaymentHandler;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay;
import org.github.finance.mall.payment.service.IPaymentRequestService;
import org.springframework.stereotype.Service;

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

    @Override
    public String createPayment(CreatePaymentDTO createPaymentDTO) throws MallPaymentException {
        log.info("--->user {} create a payment,amount:{}", createPaymentDTO.getUserId(),
                createPaymentDTO.getPaymentAmount());

        PaymentRequestDO paymentRequestDO = PaymentRequestDOHelper.toCreatePaymentRequestDO(createPaymentDTO);

        return paymentRequestService.savePaymentRequest(paymentRequestDO);
    }

    @Override
    public PaymentWay.PaymentResult applyPayment(ApplyPaymentDTO applyPaymentDTO) throws MallPaymentException {
        log.info("--->user {} apply payment:{}", applyPaymentDTO.getUserId(), applyPaymentDTO);

        return paymentHandler.applyPayment(applyPaymentDTO);
    }

}
