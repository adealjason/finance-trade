package org.github.finance.mall.account.exception;

/**
 * @author ligaofeng 2017年1月12日 下午4:19:41
 */
public class MallAccountException extends Exception {

    private static final long serialVersionUID = 447269965184940584L;

    /**
     * init BizException
     */
    public MallAccountException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallAccountException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallAccountException(Throwable cause) {
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
    public MallAccountException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
