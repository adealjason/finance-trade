package org.github.finance.mall.trade;

/**
 * 交易
 * 
 * @author ligaofeng 2017年1月15日 下午8:04:52
 */
public interface ITransaction<REQ, RSP> {

    /**
     * @return
     */
    public TransactionServiceEnum getTransactionService();

    /**
     * @param request
     * @return
     */
    public RSP invoke(REQ request);
}
