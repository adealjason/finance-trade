package org.github.finance.mall.product.exception;

/**
 * @author ligaofeng 2017年1月14日 下午11:13:52
 */
public class MallProductException extends Exception {

    private static final long serialVersionUID = 9017055604854531209L;

    /**
     * init BizException
     */
    public MallProductException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallProductException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallProductException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallProductException(Throwable cause) {
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
    public MallProductException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
