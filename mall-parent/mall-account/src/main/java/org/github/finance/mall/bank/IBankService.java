package org.github.finance.mall.bank;

import org.github.finance.mall.bank.exception.MallBankException;
import org.github.finance.mall.bank.vo.BindCardVO;
import org.github.finance.mall.bank.vo.ChangeBankPhoneVO;
import org.github.finance.mall.bank.vo.UnBindCardVO;

/**
 * @author ligaofeng 2017年1月12日 下午7:35:47
 */
public interface IBankService {

    /**
     * 绑卡
     * 
     * @param bindCardVO
     * @throws MallBankException
     */
    public void bindCard(BindCardVO bindCardVO) throws MallBankException;

    /**
     * 解绑
     * 
     * @param unBindCardVO
     * @throws MallBankException
     */
    public void unBindCard(UnBindCardVO unBindCardVO) throws MallBankException;

    /**
     * 更改银行预留手机号码
     * 
     * @param changeBankPhoneVO
     * @throws MallBankException
     */
    public void changeBankPhone(ChangeBankPhoneVO changeBankPhoneVO) throws MallBankException;
}
