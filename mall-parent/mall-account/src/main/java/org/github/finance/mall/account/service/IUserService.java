package org.github.finance.mall.account.service;

import org.github.finance.mall.account.dao.dataobject.UserDO;
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
    public String saveRegister(UserDO userRegisterDO) throws MallAccountException;
}
