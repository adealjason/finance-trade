package org.github.finance.mall.account.impl;

import javax.annotation.Resource;

import org.github.finance.mall.account.IUserAccountService;
import org.github.finance.mall.account.domain.AccountPassportDomain;
import org.github.finance.mall.account.domain.helper.AccountPassportDomainHelper;
import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.service.IUserOnlineService;
import org.github.finance.mall.account.service.IUserService;
import org.github.finance.mall.share.account.dto.LogOutDTO;
import org.github.finance.mall.share.account.dto.UserLogInDTO;
import org.github.finance.mall.share.account.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午4:56:31
 */
@Slf4j
@Service
public class UserAccountService implements IUserAccountService {

    @Resource
    private IUserService       userService;
    @Resource
    private IUserOnlineService userOnlineService;

    @Override
    public String register(UserRegisterDTO userRegisterDTO) throws MallAccountException {
        log.info("--->user {} register with loginName {} and userPhone {}", userRegisterDTO.getUserName(),
                userRegisterDTO.getLogInName(), userRegisterDTO.getUserPhone());
        AccountPassportDomain accountPassportDomain = AccountPassportDomainHelper
                .toAccountPassportDomain(userRegisterDTO);
        return userService.saveUser(accountPassportDomain);
    }

    @Override
    public boolean logIn(UserLogInDTO userLogIn) throws MallAccountException {

        return userOnlineService.logIn(userLogIn.getLogInName(), userLogIn.getLogInPassword());
    }

    @Override
    public boolean logOut(LogOutDTO logOut) throws MallAccountException {

        return userOnlineService.logOut(logOut.getLogInName());
    }

}
