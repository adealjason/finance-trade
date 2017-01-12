package org.github.finance.mall.account.impl;

import javax.annotation.Resource;

import org.github.finance.mall.account.IUserAccountService;
import org.github.finance.mall.account.dao.dataobject.UserDO;
import org.github.finance.mall.account.dao.helper.UserDOHelper;
import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.service.IUserOnlineService;
import org.github.finance.mall.account.service.IUserService;
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
public class UserAccountService implements IUserAccountService {

    @Resource
    private IUserService       userService;
    @Resource
    private IUserOnlineService userOnlineService;

    @Override
    public String register(UserRegisterVO userRegisterVO) throws MallAccountException {
        log.info("--->user {} register with loginName {} and userPhone {}", userRegisterVO.getUserName(),
                userRegisterVO.getLogInName(), userRegisterVO.getUserPhone());
        UserDO userDO = UserDOHelper.toUserRegisterDO(userRegisterVO);
        return userService.saveUser(userDO);
    }

    @Override
    public boolean logIn(UserLogInVO userLogIn) throws MallAccountException {

        return userOnlineService.logIn(userLogIn.getLogInName(), userLogIn.getLogInPassword());
    }

    @Override
    public boolean logOut(LogOutVO logOut) throws MallAccountException {

        return userOnlineService.logOut(logOut.getLogInName());
    }

}
