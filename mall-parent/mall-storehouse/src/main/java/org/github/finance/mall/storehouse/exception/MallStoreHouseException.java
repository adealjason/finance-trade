package org.github.finance.mall.storehouse.exception;

/**
 * @author ligaofeng 2017年1月15日 下午1:46:28
 */
public class MallStoreHouseException extends Exception {

    private static final long serialVersionUID = 1420277747704883404L;

    /**
     * init BizException
     */
    public MallStoreHouseException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallStoreHouseException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallStoreHouseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallStoreHouseException(Throwable cause) {
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
    public MallStoreHouseException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
