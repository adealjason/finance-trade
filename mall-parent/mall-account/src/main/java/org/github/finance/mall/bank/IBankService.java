package org.github.finance.mall.bank;

import org.github.finance.mall.bank.dto.BindCardDTO;
import org.github.finance.mall.bank.dto.ChangeBankPhoneDTO;
import org.github.finance.mall.bank.dto.UnBindCardDTO;
import org.github.finance.mall.bank.exception.MallBankException;

/**
 * @author ligaofeng 2017年1月12日 下午7:35:47
 */
public interface IBankService {

    /**
     * 绑卡
     * 
     * @param bindCardDTO
     * @throws MallBankException
     */
    public void bindCard(BindCardDTO bindCardDTO) throws MallBankException;

    /**
     * 解绑
     * 
     * @param unBindCardDTO
     * @throws MallBankException
     */
    public void unBindCard(UnBindCardDTO unBindCardDTO) throws MallBankException;

    /**
     * 更改银行预留手机号码
     * 
     * @param changeBankPhoneDTO
     * @throws MallBankException
     */
    public void changeBankPhone(ChangeBankPhoneDTO changeBankPhoneDTO) throws MallBankException;
}
