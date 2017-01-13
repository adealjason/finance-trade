package org.github.finance.mall.payment.inner.way;

import org.github.finance.mall.payment.exception.MallPaymentException;
import org.github.finance.mall.payment.inner.impl.PaymentHandler.PaymentWay;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月13日 下午3:40:01
 */
@Slf4j
@Service("weiXinPaymentWay")
public class WeiXinPaymentWay implements PaymentWay {
    @Override
    public PaymentResult applyPayment(ApplyPaymentRequest applyPaymentRequest) throws MallPaymentException {
        log.info("--->execute payment through weixin pay:{}", applyPaymentRequest);
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setResult(true);
        log.info("--->return payment result...");
        return paymentResult;
    }

}
