package org.github.finance.mall.trade.exception;

/**
 * @author ligaofeng 2017年1月15日 下午8:18:42
 */
public class MallTradeException extends Exception {

    private static final long serialVersionUID = 5295983146665955623L;

    /**
     * init BizException
     */
    public MallTradeException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallTradeException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallTradeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallTradeException(Throwable cause) {
        super(cause);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public MallTradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
