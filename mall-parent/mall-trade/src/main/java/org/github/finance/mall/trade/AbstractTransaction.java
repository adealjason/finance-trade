package org.github.finance.mall.trade;

import javax.annotation.Resource;

import org.github.finance.mall.share.trade.EventObject;
import org.github.finance.mall.trade.event.EventPublisher;
import org.github.finance.mall.trade.exception.MallTradeException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午8:11:12
 */
@Slf4j
public abstract class AbstractTransaction<REQ, RSP> implements ITransaction<REQ, RSP> {

    @Resource
    private EventPublisher eventPublisher;

    @Override
    public RSP invoke(REQ request) {
        log.info("--->transaction start:{}", request);
        RSP response = null;
        try {
            String transactionId = this.generateTransactionIdentification(request);
            TradeContext.getInstance().setTransactionId(transactionId);
            TradeContext.getInstance().setTransactionService(this.getTransactionName());

            this.initEvent(request);
            this.checkRequestDuplicated(request);
            this.checkBusinessDuplicated(request);
            this.checkParams(request);
            response = this.execute(request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            response = this.getTransactionResponseCallBack().getFailResponse(request, e);
        } finally {
            log.info("--->transaction response:{}", response);
            TradeContext.getInstance().clear();
            this.publishEvent(request);
            this.removeRequestCache(request);
        }
        return response;
    }

    protected abstract void checkParams(REQ request) throws MallTradeException;

    protected abstract RSP execute(REQ request) throws MallTradeException;

    protected abstract String generateTransactionIdentification(REQ request);

    protected abstract InitEventCallBack<REQ> getInitEventCallBack();

    protected abstract TransactionResponseCallBack<REQ, RSP> getTransactionResponseCallBack();

    protected interface InitEventCallBack<REQ> {

        /**
         * @param eventObject
         * @param request
         */
        public void assembleEvent(EventObject eventObject, REQ request);
    }

    protected interface TransactionResponseCallBack<REQ, RSP> {

        /**
         * @param request
         * @param objects
         * @return
         */
        public RSP getSuccessResponse(REQ request, Object... objects);

        /**
         * @param request
         * @param objects
         * @return
         */
        public RSP getFailResponse(REQ request, Object... objects);
    }

    private void initEvent(REQ request) {
        EventObject eventObject = new EventObject();
        eventObject.setEventId(this.generateTransactionIdentification(request));
        eventObject.setTransaction(this.getTransactionName().name());
        TradeContext.getInstance().setEventObject(eventObject);
        InitEventCallBack<REQ> initEventCallBack = this.getInitEventCallBack();
        if (initEventCallBack != null) {
            initEventCallBack.assembleEvent(eventObject, request);
        }
    }

    private void publishEvent(REQ request) {
        TransactionEnum transcationService = this.getTransactionName();
        if (transcationService != null) {
            EventObject eventObject = TradeContext.getInstance().getEventObject();
            if (eventObject == null) {
                log.warn("the request has no publish event,transcationService:{}", this.getTransactionName());
                return;
            }
            eventObject.setTransaction(this.getTransactionName().name());
            eventObject.setEventId(TradeContext.getInstance().getTransactionId());
            eventPublisher.publishAysnEvent(eventObject);
        }
    }

    private void checkBusinessDuplicated(REQ request) throws MallTradeException {
        log.info("--->check business duplicated:{}", request);
    }

    private void checkRequestDuplicated(REQ request) throws MallTradeException {
        log.info("--->check request duplicated:{}", request);
    }

    private void removeRequestCache(REQ request) {
        log.info("--->execute release lock,uniqueKey:{}", TradeContext.getInstance().getTransactionId());
    }

}
