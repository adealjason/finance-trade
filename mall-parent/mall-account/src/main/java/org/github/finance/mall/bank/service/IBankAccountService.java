package org.github.finance.mall.bank.service;

import org.github.finance.mall.bank.dao.dataobject.BankAccountDO;
import org.github.finance.mall.bank.exception.MallBankException;

/**
 * @author ligaofeng 2017年1月12日 下午8:22:33
 */
public interface IBankAccountService {

    /**
     * @param bankAccountDO
     * @throws MallBankException
     */
    public void saveBankAccount(BankAccountDO bankAccountDO) throws MallBankException;

    /**
     * @param bankAccountDO
     * @throws MallBankException
     */
    public void updateBankAccount(BankAccountDO bankAccountDO) throws MallBankException;

}
