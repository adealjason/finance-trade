package org.github.finance.mall.express.exception;

/**
 * @author ligaofeng 2017年1月15日 下午1:08:21
 */
public class MallExpressException extends Exception {

    private static final long serialVersionUID = 8872598392666507924L;

    /**
     * init BizException
     */
    public MallExpressException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallExpressException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallExpressException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallExpressException(Throwable cause) {
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
    public MallExpressException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
