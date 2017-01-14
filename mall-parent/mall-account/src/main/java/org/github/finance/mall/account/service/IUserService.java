package org.github.finance.mall.account.service;

import org.github.finance.mall.account.domain.AccountPassportDomain;
import org.github.finance.mall.account.exception.MallAccountException;

/**
 * @author ligaofeng 2017年1月12日 下午5:15:51
 */
public interface IUserService {

    /**
     * 注册
     * 
     * @param userRegisterDO
     * @return
     * @throws MallAccountException
     */
    public String saveUser(AccountPassportDomain userRegisterDO) throws MallAccountException;
}
