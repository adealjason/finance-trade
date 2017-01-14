package org.github.finance.mall.bank.service.impl;

import org.github.finance.mall.bank.dao.entity.BankAccountEntity;
import org.github.finance.mall.bank.dao.helper.BankAccountEntityHelper;
import org.github.finance.mall.bank.domain.BankAccountDomain;
import org.github.finance.mall.bank.exception.MallBankException;
import org.github.finance.mall.bank.service.IBankAccountService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午8:29:26
 */
@Slf4j
@Service
public class BankAccountService implements IBankAccountService {

    @Override
    public void saveBankAccount(BankAccountDomain bankAccountDomain) throws MallBankException {
        BankAccountEntity bankAccountEntity = BankAccountEntityHelper.toBankAccountEntity(bankAccountDomain);
        log.info("--->generate bankAccountId...");
        String bankAccountId = BankAccountIdGenerator.generateBankAccountId();
        bankAccountEntity.setId(bankAccountId);
        log.info("--->start to save bankAccountEntity:{}", bankAccountEntity);

    }

    @Override
    public void updateBankAccount(BankAccountDomain bankAccountDomain) throws MallBankException {
        BankAccountEntity bankAccountEntity = BankAccountEntityHelper.toBankAccountEntity(bankAccountDomain);
        log.info("--->start to update bankAccountEntity:{}", bankAccountEntity);
    }

    /**
     * @author ligaofeng 2017年1月12日 下午8:39:04
     */
    private static class BankAccountIdGenerator {

        private BankAccountIdGenerator() {
        }

        /**
         * @return
         */
        public static String generateBankAccountId() {
            return String.valueOf((int) ((Math.random() * 9 + 1) * 100000000));
        }
    }

}
