package org.github.finance.mall.bank.service;

import org.github.finance.mall.bank.domain.BankAccountDomain;
import org.github.finance.mall.bank.exception.MallBankException;

/**
 * @author ligaofeng 2017年1月12日 下午8:22:33
 */
public interface IBankAccountService {

    /**
     * @param bankAccountDomain
     * @throws MallBankException
     */
    public void saveBankAccount(BankAccountDomain bankAccountDomain) throws MallBankException;

    /**
     * @param bankAccountDomain
     * @throws MallBankException
     */
    public void updateBankAccount(BankAccountDomain bankAccountDomain) throws MallBankException;

}
