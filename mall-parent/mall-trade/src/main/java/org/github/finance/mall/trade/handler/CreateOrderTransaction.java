package org.github.finance.mall.trade.handler;

import java.util.UUID;

import javax.annotation.Resource;

import org.github.finance.mall.order.IOrderService;
import org.github.finance.mall.order.exception.MallOrderException;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;
import org.github.finance.mall.share.trade.EventObject;
import org.github.finance.mall.share.trade.TransactionResult;
import org.github.finance.mall.share.trade.request.CreateOrderRequest;
import org.github.finance.mall.share.trade.response.CreateOrderResponse;
import org.github.finance.mall.trade.AbstractTransaction;
import org.github.finance.mall.trade.TransactionEnum;
import org.github.finance.mall.trade.exception.MallTradeException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午8:07:57
 */
@Slf4j
@Service("createOrderTransaction")
public class CreateOrderTransaction extends AbstractTransaction<CreateOrderRequest, CreateOrderResponse> {

    @Resource
    private IOrderService orderService;

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
        try {
            CreateOrderDTO createOrderDTO = new CreateOrderDTO();
            BeanUtils.copyProperties(request, createOrderDTO);
            String orderId = orderService.createOrder(createOrderDTO);
            return this.getTransactionResponseCallBack().getSuccessResponse(request, orderId);
        } catch (MallOrderException e) {
            log.error(e.getMessage(), e);
            return this.getTransactionResponseCallBack().getFailResponse(request, e);
        }
    }

    @Override
    protected String generateTransactionIdentification(CreateOrderRequest request) {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    protected InitEventCallBack<CreateOrderRequest> getInitEventCallBack() {
        return initEventCallBack;
    }

    private static final InitEventCallBack<CreateOrderRequest> initEventCallBack = new InitEventCallBack<CreateOrderRequest>() {

        @Override
        public void assembleEvent(EventObject eventObject, CreateOrderRequest request) {
            log.info("assemble event:{}", request);

        }
    };

    @Override
    protected TransactionResponseCallBack<CreateOrderRequest, CreateOrderResponse> getTransactionResponseCallBack() {

        return createOrderResponseCallBack;
    }

    private static final TransactionResponseCallBack<CreateOrderRequest, CreateOrderResponse> createOrderResponseCallBack = new TransactionResponseCallBack<CreateOrderRequest, CreateOrderResponse>() {

        @Override
        public CreateOrderResponse getSuccessResponse(CreateOrderRequest request, Object... objects) {
            CreateOrderResponse createOrderResponse = new CreateOrderResponse();
            createOrderResponse.setTransactionResult(TransactionResult.SUCCESS);
            createOrderResponse.setOrderId((String) objects[0]);
            return createOrderResponse;
        }

        @Override
        public CreateOrderResponse getFailResponse(CreateOrderRequest request, Object... objects) {
            Exception e = (Exception) objects[0];
            CreateOrderResponse createOrderResponse = new CreateOrderResponse();
            createOrderResponse.setTransactionResult(TransactionResult.FAIL);
            createOrderResponse.setErrorMessage(e.getMessage());
            return createOrderResponse;
        }
    };

}
