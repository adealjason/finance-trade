package org.github.finance.mall.bank.dao.helper;

import org.github.finance.mall.bank.dao.entity.BankAccountEntity;
import org.github.finance.mall.bank.domain.BankAccountDomain;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午8:30:42
 */
public class BankAccountEntityHelper {

    private BankAccountEntityHelper() {
    }

    /**
     * @param bankAccountDomain
     * @return
     */
    public static BankAccountEntity toBankAccountEntity(BankAccountDomain bankAccountDomain) {
        DateTime now = DateTime.now();

        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setCreator("system");
        bankAccountEntity.setModifier("system");
        bankAccountEntity.setIsDeleted("N");
        bankAccountEntity.setGmtCreated(now.toDate());
        bankAccountEntity.setGmtModified(now.toDate());
        bankAccountEntity.setBankPhone(bankAccountDomain.getBankPhone());
        bankAccountEntity.setCardNo(bankAccountDomain.getCardNo());
        bankAccountEntity.setCertNo(bankAccountDomain.getCertNo());
        bankAccountEntity.setStatus(bankAccountDomain.getStatus().name());
        bankAccountEntity.setUserId(bankAccountDomain.getUserId());
        return bankAccountEntity;
    }
}
