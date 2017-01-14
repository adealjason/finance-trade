package org.github.finance.mall.account.dao.helper;

import org.github.finance.mall.account.dao.entity.UserEntity;
import org.github.finance.mall.account.domain.AccountPassportDomain;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午5:46:44
 */
public class UserEntityHelper {

    private UserEntityHelper() {
    }

    /**
     * @param accountPassportDomain
     * @return
     */
    public static UserEntity toUserRegisterEntity(AccountPassportDomain accountPassportDomain) {
        DateTime now = DateTime.now();
        UserEntity userEntity = new UserEntity();
        userEntity.setCreator("system");
        userEntity.setModifier("system");
        userEntity.setIsDeleted("N");
        userEntity.setGmtCreated(now.toDate());
        userEntity.setGmtModified(now.toDate());
        userEntity.setLogInName(accountPassportDomain.getLogInName());
        userEntity.setLogInPassword(accountPassportDomain.getLogInPassword());
        userEntity.setUserName(accountPassportDomain.getUserName());
        userEntity.setUserPhone(accountPassportDomain.getUserPhone());
        return userEntity;
    }

}
