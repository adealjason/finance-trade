package org.github.finance.mall.share.trade.response;

import java.io.Serializable;

import org.github.finance.mall.share.trade.TransactionResult;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月16日 下午1:10:18
 */
@Data
public class PaymentResponse implements Serializable {

    private static final long serialVersionUID = -3356721135056290170L;

    private TransactionResult transactionResult;

    private String            errorMessage;

    private String            orderId;

    private String            paymentId;

    private boolean           paymentResult;
}
