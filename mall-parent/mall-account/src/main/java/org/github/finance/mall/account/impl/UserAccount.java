package org.github.finance.mall.account.impl;

import javax.annotation.Resource;

import org.github.finance.mall.account.IUserAccount;
import org.github.finance.mall.account.dao.dataobject.UserRegisterDO;
import org.github.finance.mall.account.dao.helper.UserRegisterDOHelper;
import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.service.IUserOnline;
import org.github.finance.mall.account.service.IUserRegister;
import org.github.finance.mall.account.vo.LogOutVO;
import org.github.finance.mall.account.vo.UserLogInVO;
import org.github.finance.mall.account.vo.UserRegisterVO;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午4:56:31
 */
@Slf4j
@Service
public class UserAccount implements IUserAccount {

    @Resource
    private IUserRegister userRegister;
    @Resource
    private IUserOnline   userOnline;

    @Override
    public String register(UserRegisterVO userRegisterVO) throws MallAccountException {
        log.info("--->user {} register with loginName {} and userPhone {}", userRegisterVO.getUserName(),
                userRegisterVO.getLogInName(), userRegisterVO.getUserPhone());
        UserRegisterDO userRegisterDO = UserRegisterDOHelper.toUserRegisterDO(userRegisterVO);
        return userRegister.saveRegister(userRegisterDO);
    }

    @Override
    public boolean logIn(UserLogInVO userLogIn) throws MallAccountException {

        return userOnline.logIn(userLogIn.getLogInName(), userLogIn.getLogInPassword());
    }

    @Override
    public boolean logOut(LogOutVO logOut) throws MallAccountException {

        return userOnline.logOut(logOut.getLogInName());
    }

}
