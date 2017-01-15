package org.github.finance.mall.trade.handler;

import org.github.finance.mall.share.trade.request.CreateOrderRequest;
import org.github.finance.mall.share.trade.response.CreateOrderResponse;
import org.github.finance.mall.trade.AbstractTransaction;
import org.github.finance.mall.trade.TransactionServiceEnum;
import org.github.finance.mall.trade.exception.MallTradeException;

/**
 * @author ligaofeng 2017年1月15日 下午8:07:57
 */
public class CreateOrderTransaction extends AbstractTransaction<CreateOrderRequest, CreateOrderResponse> {

    @Override
    public TransactionServiceEnum getTransactionService() {
        return TransactionServiceEnum.ORDER;
    }

    @Override
    protected void checkParams(CreateOrderRequest request) throws MallTradeException {

    }

    @Override
    protected void initEvent(CreateOrderRequest request) {

    }

    @Override
    protected CreateOrderResponse execute(CreateOrderRequest request) throws MallTradeException {

        return null;
    }

    @Override
    protected String generateTransactionIdentification(CreateOrderRequest request) {

        return null;
    }

}
