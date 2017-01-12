package org.github.finance.mall.account.dao.helper;

import org.github.finance.mall.account.dao.dataobject.UserRegisterDO;
import org.github.finance.mall.account.vo.UserRegisterVO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午5:46:44
 */
public class UserRegisterDOHelper {

    private UserRegisterDOHelper() {
    }

    /**
     * @param userRegisterVO
     * @return
     */
    public static UserRegisterDO toUserRegisterDO(UserRegisterVO userRegisterVO) {
        DateTime now = DateTime.now();
        UserRegisterDO userRegisterDO = new UserRegisterDO();
        userRegisterDO.setCreator("system");
        userRegisterDO.setModifier("system");
        userRegisterDO.setIsDeleted("N");
        userRegisterDO.setGmtCreated(now.toDate());
        userRegisterDO.setGmtModified(now.toDate());
        userRegisterDO.setLogInName(userRegisterVO.getLogInName());
        userRegisterDO.setLogInPassword(userRegisterVO.getLogInPassword());
        userRegisterDO.setUserName(userRegisterVO.getUserName());
        userRegisterDO.setUserPhone(userRegisterVO.getUserPhone());
        return userRegisterDO;
    }

}
