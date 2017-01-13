package org.github.finance.mall.bank.dao.helper;

import org.github.finance.mall.bank.constance.BindCardStatusEnum;
import org.github.finance.mall.bank.dao.dataobject.BankAccountDO;
import org.github.finance.mall.bank.dto.BindCardDTO;
import org.github.finance.mall.bank.dto.ChangeBankPhoneDTO;
import org.github.finance.mall.bank.dto.UnBindCardDTO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午8:30:42
 */
public class BankAccountDOHelper {

    private BankAccountDOHelper() {
    }

    /**
     * @param bindCardDTO
     * @return
     */
    public static BankAccountDO toBankAccountDO(BindCardDTO bindCardDTO) {
        DateTime now = DateTime.now();

        BankAccountDO bankAccountDO = new BankAccountDO();
        bankAccountDO.setCreator("system");
        bankAccountDO.setModifier("system");
        bankAccountDO.setIsDeleted("N");
        bankAccountDO.setGmtCreated(now.toDate());
        bankAccountDO.setGmtModified(now.toDate());
        bankAccountDO.setBankPhone(bindCardDTO.getBankPhone());
        bankAccountDO.setCardNo(bindCardDTO.getCardNo());
        bankAccountDO.setCertNo(bindCardDTO.getCertNo());
        bankAccountDO.setStatus(BindCardStatusEnum.BIND.name());
        bankAccountDO.setUserId(bindCardDTO.getUserId());
        return bankAccountDO;
    }

    /**
     * @param unbindCardDTO
     * @return
     */
    public static BankAccountDO toBankAccountDO(UnBindCardDTO unbindCardDTO) {
        BankAccountDO bankAccountDO = new BankAccountDO();
        bankAccountDO.setUserId(unbindCardDTO.getUserId());
        bankAccountDO.setId(unbindCardDTO.getBankAccountId());
        bankAccountDO.setStatus(BindCardStatusEnum.UNBIND.name());
        return bankAccountDO;
    }

    /**
     * @param changeBankPhoneDTO
     * @return
     */
    public static BankAccountDO toBankAccountDO(ChangeBankPhoneDTO changeBankPhoneDTO) {
        BankAccountDO bankAccountDO = new BankAccountDO();
        bankAccountDO.setUserId(changeBankPhoneDTO.getUserId());
        bankAccountDO.setId(changeBankPhoneDTO.getBankAccountId());
        bankAccountDO.setBankPhone(changeBankPhoneDTO.getDestBankPhone());
        return bankAccountDO;
    }
}
