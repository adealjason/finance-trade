package org.github.finance.mall.account.service.impl;

import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.service.IUserOnline;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午6:06:10
 */
@Slf4j
@Service
public class UserOnline implements IUserOnline {

    @Override
    public boolean logIn(String logInName, String logInPassword) throws MallAccountException {
        log.info("--->user {} will logIn", logInName);
        return true;
    }

    @Override
    public boolean logOut(String logInName) throws MallAccountException {
        log.info("--->user {} will logOut", logInName);
        return true;
    }

}
