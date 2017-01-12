package org.github.finance.mall.bank.impl;

import org.github.finance.mall.bank.IBankService;
import org.github.finance.mall.bank.exception.MallBankException;
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

    @Override
    public void bindCard(BindCardVO bindCardVO) throws MallBankException {
        log.info("--->user {} will to bind card {}", bindCardVO.getUserId(), bindCardVO.getCardNo());

        log.info("--->check whether the card is binded...");

        log.info("--->check the card through the bank...");

        log.info("--->bind card success,save the recored...");
    }

    @Override
    public void unBindCard(UnBindCardVO unBindCardVO) throws MallBankException {

    }

    @Override
    public void changeBankPhone(ChangeBankPhoneVO changeBankPhoneVO) throws MallBankException {

    }

}
