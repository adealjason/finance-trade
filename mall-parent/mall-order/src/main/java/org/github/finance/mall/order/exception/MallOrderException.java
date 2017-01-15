package org.github.finance.mall.order.exception;

/**
 * @author ligaofeng 2017年1月15日 下午2:09:48
 */
public class MallOrderException extends Exception {

    private static final long serialVersionUID = -5226947490026290311L;

    /**
     * init BizException
     */
    public MallOrderException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallOrderException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallOrderException(Throwable cause) {
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
    public MallOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
