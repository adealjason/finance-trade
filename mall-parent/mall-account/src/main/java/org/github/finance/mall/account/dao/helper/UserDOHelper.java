package org.github.finance.mall.account.dao.helper;

import org.github.finance.mall.account.dao.dataobject.UserDO;
import org.github.finance.mall.account.vo.UserRegisterVO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午5:46:44
 */
public class UserDOHelper {

    private UserDOHelper() {
    }

    /**
     * @param userRegisterVO
     * @return
     */
    public static UserDO toUserRegisterDO(UserRegisterVO userRegisterVO) {
        DateTime now = DateTime.now();
        UserDO userDO = new UserDO();
        userDO.setCreator("system");
        userDO.setModifier("system");
        userDO.setIsDeleted("N");
        userDO.setGmtCreated(now.toDate());
        userDO.setGmtModified(now.toDate());
        userDO.setLogInName(userRegisterVO.getLogInName());
        userDO.setLogInPassword(userRegisterVO.getLogInPassword());
        userDO.setUserName(userRegisterVO.getUserName());
        userDO.setUserPhone(userRegisterVO.getUserPhone());
        return userDO;
    }

}
