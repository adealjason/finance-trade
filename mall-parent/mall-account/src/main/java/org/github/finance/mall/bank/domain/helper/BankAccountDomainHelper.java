package org.github.finance.mall.bank.domain.helper;

import org.github.finance.mall.bank.domain.BankAccountDomain;
import org.github.finance.mall.share.bank.dto.BindCardDTO;
import org.github.finance.mall.share.bank.dto.ChangeBankPhoneDTO;
import org.github.finance.mall.share.bank.dto.UnBindCardDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author ligaofeng 2017年1月14日 下午9:04:48
 */
public class BankAccountDomainHelper {

    private BankAccountDomainHelper() {
    }

    /**
     * @param bindCardDTO
     * @return
     */
    public static BankAccountDomain toBankAccountDomain(BindCardDTO bindCardDTO) {
        if (bindCardDTO == null) {
            return null;
        }
        BankAccountDomain bankAccountDomain = new BankAccountDomain();
        BeanUtils.copyProperties(bindCardDTO, bankAccountDomain);
        return bankAccountDomain;
    }

    /**
     * @param unBindCardDTO
     * @return
     */
    public static BankAccountDomain toBankAccountDomain(UnBindCardDTO unBindCardDTO) {

        if (unBindCardDTO == null) {
            return null;
        }
        BankAccountDomain bankAccountDomain = new BankAccountDomain();
        BeanUtils.copyProperties(unBindCardDTO, bankAccountDomain);
        return bankAccountDomain;
    }

    /**
     * @param changeBankPhoneDTO
     * @return
     */
    public static BankAccountDomain toBankAccountDomain(ChangeBankPhoneDTO changeBankPhoneDTO) {
        BankAccountDomain bankAccountDomain = new BankAccountDomain();
        bankAccountDomain.setUserId(changeBankPhoneDTO.getUserId());
        bankAccountDomain.setBankAccountId(changeBankPhoneDTO.getBankAccountId());
        bankAccountDomain.setBankPhone(changeBankPhoneDTO.getDestBankPhone());
        return bankAccountDomain;
    }
}
