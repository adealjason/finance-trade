package org.github.finance.mall.trade.transaction;

import java.util.UUID;

import javax.annotation.Resource;

import org.github.finance.mall.payment.IPaymentService;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay;
import org.github.finance.mall.share.payment.dto.ApplyPaymentDTO;
import org.github.finance.mall.share.trade.EventObject;
import org.github.finance.mall.share.trade.TransactionResult;
import org.github.finance.mall.share.trade.request.PaymentRequest;
import org.github.finance.mall.share.trade.response.PaymentResponse;
import org.github.finance.mall.trade.AbstractTransaction;
import org.github.finance.mall.trade.TransactionEnum;
import org.github.finance.mall.trade.exception.MallTradeException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 支付交易
 * 
 * @author ligaofeng 2017年1月16日 下午1:09:27
 */
@Slf4j
@Service("paymentTransaction")
public class PaymentTransaction extends AbstractTransaction<PaymentRequest, PaymentResponse> {

    @Resource
    private IPaymentService paymentService;

    @Override
    public TransactionEnum getTransactionName() {

        return TransactionEnum.PAYMENT;
    }

    @Override
    protected void checkParams(PaymentRequest request) throws MallTradeException {
        log.info("--->check params:{}", request);

    }

    @Override
    protected PaymentResponse execute(PaymentRequest request) throws MallTradeException {
        try {
            ApplyPaymentDTO applyPaymentDTO = new ApplyPaymentDTO();
            BeanUtils.copyProperties(request, applyPaymentDTO);
            PaymentWay.PaymentResult paymentResult = paymentService.applyPayment(applyPaymentDTO);
            return this.getTransactionResponseCallBack().getSuccessResponse(request, paymentResult);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return this.getTransactionResponseCallBack().getFailResponse(request, e);
        }
    }

    @Override
    protected String generateTransactionIdentification(PaymentRequest request) {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    protected InitEventCallBack<PaymentRequest> getInitEventCallBack() {

        return initEventCallBack;
    }

    private static final InitEventCallBack<PaymentRequest> initEventCallBack = new InitEventCallBack<PaymentRequest>() {

        @Override
        public void assembleEvent(EventObject eventObject, PaymentRequest request) {
            log.info("assemble event:{},request:{}", eventObject, request);
        }
    };

    @Override
    protected TransactionResponseCallBack<PaymentRequest, PaymentResponse> getTransactionResponseCallBack() {

        return paymentResponseCallBack;
    }

    private TransactionResponseCallBack<PaymentRequest, PaymentResponse> paymentResponseCallBack = new TransactionResponseCallBack<PaymentRequest, PaymentResponse>() {

        @Override
        public PaymentResponse getSuccessResponse(PaymentRequest request, Object... objects) {
            PaymentWay.PaymentResult paymentResult = (PaymentWay.PaymentResult) objects[0];
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setTransactionResult(TransactionResult.SUCCESS);
            paymentResponse.setOrderId(paymentResult.getOrderId());
            paymentResponse.setPaymentId(paymentResult.getPaymentId());
            paymentResponse.setPaymentResult(paymentResult.isResult());
            return paymentResponse;
        }

        @Override
        public PaymentResponse getFailResponse(PaymentRequest request, Object... objects) {
            Exception e = (Exception) objects[0];
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setTransactionResult(TransactionResult.FAIL);
            paymentResponse.setErrorMessage(e.getMessage());
            paymentResponse.setOrderId(request.getOrderId());
            paymentResponse.setPaymentId(request.getPaymentRequestId());
            return paymentResponse;
        }
    };

}
