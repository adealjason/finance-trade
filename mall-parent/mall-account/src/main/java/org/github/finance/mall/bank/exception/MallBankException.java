package org.github.finance.mall.bank.exception;

/**
 * @author ligaofeng 2017年1月12日 下午7:38:17
 */
public class MallBankException extends Exception {

    private static final long serialVersionUID = -7440125304766897628L;

    /**
     * init BizException
     */
    public MallBankException() {
        super();
    }

    /**
     * init BizException
     * 
     * @param message
     */
    public MallBankException(String message) {
        super(message);
    }

    /**
     * init BizException
     * 
     * @param message
     * @param cause
     */
    public MallBankException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * init BizException
     * 
     * @param cause
     */
    public MallBankException(Throwable cause) {
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
    public MallBankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
