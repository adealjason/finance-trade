package org.github.finance.mall.account.service;

import org.github.finance.mall.account.exception.MallAccountException;

/**
 * @author ligaofeng 2017年1月12日 下午6:04:34
 */
public interface IUserOnline {

    /**
     * 用户登录
     * 
     * @param logInName
     * @param logInPassword
     * @return
     * @throws MallAccountException
     */
    public boolean logIn(String logInName, String logInPassword) throws MallAccountException;

    /**
     * 登出
     * 
     * @param logInName
     * @return
     * @throws MallAccountException
     */
    public boolean logOut(String logInName) throws MallAccountException;
}
