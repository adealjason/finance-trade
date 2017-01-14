package org.github.finance.mall.account;

import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.share.account.dto.LogOutDTO;
import org.github.finance.mall.share.account.dto.UserLogInDTO;
import org.github.finance.mall.share.account.dto.UserRegisterDTO;

/**
 * 用户注册
 * 
 * @author ligaofeng 2017年1月12日 下午3:13:20
 */
public interface IUserAccountService {

    /**
     * 用户注册
     * 
     * @param userRegisterDTO
     * @return
     * @throws MallAccountException
     */
    public String register(UserRegisterDTO userRegisterDTO) throws MallAccountException;

    /**
     * 登录
     * 
     * @param userLogInDTO
     * @return
     * @throws MallAccountException
     */
    public boolean logIn(UserLogInDTO userLogInDTO) throws MallAccountException;

    /**
     * 退出
     * 
     * @param logOut
     * @return
     * @throws MallAccountException
     */
    public boolean logOut(LogOutDTO logOut) throws MallAccountException;

}
