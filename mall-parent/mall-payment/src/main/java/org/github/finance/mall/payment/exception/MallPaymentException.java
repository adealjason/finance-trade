package org.github.finance.mall.payment.exception;

/**
 * @author ligaofeng 2017年1月13日 下午12:55:49
 */
public class MallPaymentException extends Exception {

    private static final long serialVersionUID = -3969385915191410317L;

    /**
     * init BizException
     */
    public MallPaymentException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallPaymentException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallPaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallPaymentException(Throwable cause) {
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
    public MallPaymentException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
