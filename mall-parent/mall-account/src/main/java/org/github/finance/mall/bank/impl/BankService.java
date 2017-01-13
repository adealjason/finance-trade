package org.github.finance.mall.bank.impl;

import javax.annotation.Resource;

import org.github.finance.mall.bank.IBankService;
import org.github.finance.mall.bank.dao.dataobject.BankAccountDO;
import org.github.finance.mall.bank.dao.helper.BankAccountDOHelper;
import org.github.finance.mall.bank.dto.BindCardDTO;
import org.github.finance.mall.bank.dto.ChangeBankPhoneDTO;
import org.github.finance.mall.bank.dto.UnBindCardDTO;
import org.github.finance.mall.bank.exception.MallBankException;
import org.github.finance.mall.bank.service.IBankAccountService;
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
    public void bindCard(BindCardDTO bindCardDTO) throws MallBankException {
        log.info("--->user {} will to bind card {}", bindCardDTO.getUserId(), bindCardDTO.getCardNo());

        log.info("--->check whether the card is binded...");

        log.info("--->check the card through the bank...");

        log.info("--->bind card success,save the recored...");
        BankAccountDO bankAccountDO = BankAccountDOHelper.toBankAccountDO(bindCardDTO);
        bankAccountService.saveBankAccount(bankAccountDO);
    }

    @Override
    public void unBindCard(UnBindCardDTO unBindCardDTO) throws MallBankException {

        log.info("--->unBindCard cast to bankAccountDO by unBindCardDTO:{}", unBindCardDTO);
        BankAccountDO bankAccountDO = BankAccountDOHelper.toBankAccountDO(unBindCardDTO);

        bankAccountService.updateBankAccount(bankAccountDO);
    }

    @Override
    public void changeBankPhone(ChangeBankPhoneDTO changeBankPhoneDTO) throws MallBankException {

        log.info("--->changeBankPhone validate the sourceBankPhone...");

        log.info("--->cast to bankAccountDO by changeBankPhoneDTO:{}", changeBankPhoneDTO);
        BankAccountDO bankAccountDO = BankAccountDOHelper.toBankAccountDO(changeBankPhoneDTO);

        bankAccountService.updateBankAccount(bankAccountDO);
    }

}
