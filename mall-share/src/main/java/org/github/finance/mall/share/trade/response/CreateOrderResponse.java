package org.github.finance.mall.share.trade.response;

import java.io.Serializable;

import org.github.finance.mall.share.trade.TransactionResult;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午8:09:34
 */
@Data
public class CreateOrderResponse implements Serializable {

    private static final long serialVersionUID = 6462729016927654785L;

    private TransactionResult transactionResult;

    private String            errorMessage;

    private String            orderId;

}
