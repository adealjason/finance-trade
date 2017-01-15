package org.github.finance.mall.trade.handler;

import java.util.UUID;

import org.github.finance.mall.share.trade.EventObject;
import org.github.finance.mall.share.trade.request.CreateOrderRequest;
import org.github.finance.mall.share.trade.response.CreateOrderResponse;
import org.github.finance.mall.trade.AbstractTransaction;
import org.github.finance.mall.trade.TransactionEnum;
import org.github.finance.mall.trade.exception.MallTradeException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午8:07:57
 */
@Slf4j
@Service("createOrderTransaction")
public class CreateOrderTransaction extends AbstractTransaction<CreateOrderRequest, CreateOrderResponse> {

    @Override
    public TransactionEnum getTransactionName() {
        return TransactionEnum.ORDER;
    }

    @Override
    protected void checkParams(CreateOrderRequest request) throws MallTradeException {
        log.info("--->check params:{}", request);
    }

    @Override
    protected CreateOrderResponse execute(CreateOrderRequest request) throws MallTradeException {

        return null;
    }

    @Override
    protected String generateTransactionIdentification(CreateOrderRequest request) {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    protected InitEventCallBack setInitEventCallBack(final CreateOrderRequest request) {
        return new InitEventCallBack() {

            @Override
            public void assembleEvent(EventObject eventObject) {
                log.info("assemble event:{}", request);

            }
        };
    }

}
