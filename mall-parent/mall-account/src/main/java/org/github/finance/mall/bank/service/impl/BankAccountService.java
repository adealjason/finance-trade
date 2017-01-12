package org.github.finance.mall.bank.service.impl;

import org.github.finance.mall.bank.dao.dataobject.BankAccountDO;
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
    public void saveBankAccount(BankAccountDO bankAccountDO) throws MallBankException {
        log.info("--->get bankName by cardNo...");
        String bankName = BankConstrol.getBankName(bankAccountDO.getCardNo());
        bankAccountDO.setBankName(bankName);

        log.info("--->generate bankAccountId...");
        String bankAccountId = BankAccountIdGenerator.generateBankAccountId();
        bankAccountDO.setId(bankAccountId);

        log.info("--->start to save bankAccountDO:{}", bankAccountDO);

    }

    @Override
    public void updateBankAccount(BankAccountDO bankAccountDO) throws MallBankException {

    }

    /**
     * @author ligaofeng 2017年1月12日 下午8:39:04
     */
    private static class BankAccountIdGenerator {

        /**
         * @return
         */
        public static String generateBankAccountId() {
            return String.valueOf((int) ((Math.random() * 9 + 1) * 100000000));
        }
    }

    /**
     * @author ligaofeng 2017年1月12日 下午8:37:19
     */
    private static class BankConstrol {

        /**
         * 根据卡号获取银行名称
         * 
         * @param cardNo
         * @return
         */
        public static String getBankName(String cardNo) {
            return "ICBC";
        }
    }

}
