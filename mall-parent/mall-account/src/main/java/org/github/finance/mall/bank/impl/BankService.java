package org.github.finance.mall.bank.impl;

import javax.annotation.Resource;

import org.github.finance.mall.bank.IBankService;
import org.github.finance.mall.bank.dao.dataobject.BankAccountDO;
import org.github.finance.mall.bank.dao.helper.BankAccountDOHelper;
import org.github.finance.mall.bank.exception.MallBankException;
import org.github.finance.mall.bank.service.IBankAccountService;
import org.github.finance.mall.bank.vo.BindCardVO;
import org.github.finance.mall.bank.vo.ChangeBankPhoneVO;
import org.github.finance.mall.bank.vo.UnBindCardVO;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午7:36:45
 */
@Slf4j
@Service
public class BankService implements IBankService {

    @Resource
    private IBankAccountService bankAccountService;

    @Override
    public void bindCard(BindCardVO bindCardVO) throws MallBankException {
        log.info("--->user {} will to bind card {}", bindCardVO.getUserId(), bindCardVO.getCardNo());

        log.info("--->check whether the card is binded...");

        log.info("--->check the card through the bank...");

        log.info("--->bind card success,save the recored...");
        BankAccountDO bankAccountDO = BankAccountDOHelper.toBankAccountDO(bindCardVO);
        bankAccountService.saveBankAccount(bankAccountDO);
    }

    @Override
    public void unBindCard(UnBindCardVO unBindCardVO) throws MallBankException {

        log.info("--->unBindCard cast to bankAccountDO by unBindCardVO:{}", unBindCardVO);
        BankAccountDO bankAccountDO = BankAccountDOHelper.toBankAccountDO(unBindCardVO);

        bankAccountService.updateBankAccount(bankAccountDO);
    }

    @Override
    public void changeBankPhone(ChangeBankPhoneVO changeBankPhoneVO) throws MallBankException {

        log.info("--->changeBankPhone validate the sourceBankPhone...");

        log.info("--->cast to bankAccountDO by changeBankPhoneVO:{}", changeBankPhoneVO);
        BankAccountDO bankAccountDO = BankAccountDOHelper.toBankAccountDO(changeBankPhoneVO);

        bankAccountService.updateBankAccount(bankAccountDO);
    }

}
