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
        RSP rsp = null;
        try {
            String transactionId = this.generateTransactionIdentification(request);
            TradeContext.getInstance().setTransactionId(transactionId);
            TradeContext.getInstance().setTransactionService(this.getTransactionName());

            this.initEvent(request);
            this.checkRequestDuplicated(request);
            this.checkBusinessDuplicated(request);
            this.checkParams(request);
            return this.execute(request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            TradeContext.getInstance().clear();
            this.publishEvent(request);
            this.removeRequestCache(request);
        }
        return rsp;
    }

    protected abstract void checkParams(REQ request) throws MallTradeException;

    protected abstract void initEvent(REQ request);

    protected abstract RSP execute(REQ request) throws MallTradeException;

    protected abstract String generateTransactionIdentification(REQ request);

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
