package org.github.finance.mall.account;

import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.vo.LogOutVO;
import org.github.finance.mall.account.vo.UserLogInVO;
import org.github.finance.mall.account.vo.UserRegisterVO;

/**
 * 用户注册
 * 
 * @author ligaofeng 2017年1月12日 下午3:13:20
 */
public interface IUserAccount {

    /**
     * 用户注册
     * 
     * @param userRegisterVO
     * @return
     * @throws MallAccountException
     */
    public String register(UserRegisterVO userRegisterVO) throws MallAccountException;

    /**
     * 登录
     * 
     * @param userLogInVO
     * @return
     * @throws MallAccountException
     */
    public boolean logIn(UserLogInVO userLogInVO) throws MallAccountException;

    /**
     * 退出
     * 
     * @param logOut
     * @return
     * @throws MallAccountException
     */
    public boolean logOut(LogOutVO logOut) throws MallAccountException;

}
