package org.github.finance.mall.account.dao.helper;

import org.github.finance.mall.account.dao.dataobject.UserDO;
import org.github.finance.mall.account.dto.UserRegisterDTO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月12日 下午5:46:44
 */
public class UserDOHelper {

    private UserDOHelper() {
    }

    /**
     * @param userRegisterDTO
     * @return
     */
    public static UserDO toUserRegisterDO(UserRegisterDTO userRegisterDTO) {
        DateTime now = DateTime.now();
        UserDO userDO = new UserDO();
        userDO.setCreator("system");
        userDO.setModifier("system");
        userDO.setIsDeleted("N");
        userDO.setGmtCreated(now.toDate());
        userDO.setGmtModified(now.toDate());
        userDO.setLogInName(userRegisterDTO.getLogInName());
        userDO.setLogInPassword(userRegisterDTO.getLogInPassword());
        userDO.setUserName(userRegisterDTO.getUserName());
        userDO.setUserPhone(userRegisterDTO.getUserPhone());
        return userDO;
    }

}
