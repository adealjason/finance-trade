package org.github.finance.mall.bank;

import org.github.finance.mall.bank.exception.MallBankException;

/**
 * @author ligaofeng 2017年1月12日 下午7:35:47
 */
public interface IBankService {

    public void bindCard() throws MallBankException;
}
