package org.github.finance.mall.bank.dao.helper;

import org.github.finance.mall.bank.dao.dataobject.BankAccountDO;
import org.github.finance.mall.bank.vo.BindCardVO;
import org.github.finance.mall.bank.vo.ChangeBankPhoneVO;
import org.github.finance.mall.bank.vo.UnBindCardVO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午8:30:42
 */
public class BankAccountDOHelper {

    private BankAccountDOHelper() {
    }

    /**
     * @param bindCardVO
     * @return
     */
    public static BankAccountDO toBankAccountDO(BindCardVO bindCardVO) {
        DateTime now = DateTime.now();

        BankAccountDO bankAccountDO = new BankAccountDO();
        bankAccountDO.setCreator("system");
        bankAccountDO.setModifier("system");
        bankAccountDO.setIsDeleted("N");
        bankAccountDO.setGmtCreated(now.toDate());
        bankAccountDO.setGmtModified(now.toDate());
        bankAccountDO.setBankPhone(bindCardVO.getBankPhone());
        bankAccountDO.setCardNo(bindCardVO.getCardNo());
        bankAccountDO.setCertNo(bindCardVO.getCertNo());
        bankAccountDO.setStatus("BIND");
        bankAccountDO.setUserId(bindCardVO.getUserId());
        return bankAccountDO;
    }

    /**
     * @param unBindCardVO
     * @return
     */
    public static BankAccountDO toBankAccountDO(UnBindCardVO unBindCardVO) {
        BankAccountDO bankAccountDO = new BankAccountDO();
        bankAccountDO.setUserId(unBindCardVO.getUserId());
        bankAccountDO.setId(unBindCardVO.getBankAccountId());
        bankAccountDO.setStatus("UNBIND");
        return bankAccountDO;
    }

    public static BankAccountDO toBankAccountDO(ChangeBankPhoneVO changeBankPhoneVO) {
        BankAccountDO bankAccountDO = new BankAccountDO();
        bankAccountDO.setUserId(changeBankPhoneVO.getUserId());
        bankAccountDO.setId(changeBankPhoneVO.getBankAccountId());
        bankAccountDO.setBankPhone(changeBankPhoneVO.getDestBankPhone());
        return bankAccountDO;
    }
}
