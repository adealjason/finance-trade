package org.github.finance.mall.account.service.impl;

import org.github.finance.mall.account.dao.dataobject.UserDO;
import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.service.IUserService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午5:21:13
 */
@Slf4j
@Service
public class UserService implements IUserService {

    @Override
    public String saveRegister(UserDO userDO) throws MallAccountException {

        log.info("--> check field is not null...");

        log.info("--->check user is not register before...");

        String userId = UserIdGenerator.generateUserId();
        userDO.setId(userId);

        log.info("--->start to register...");

        return userId;
    }

    /**
     * 用户id
     * 
     * @author ligaofeng 2017年1月12日 下午5:34:33
     */
    private static class UserIdGenerator {

        /**
         * @return
         */
        public static String generateUserId() {

            return String.valueOf((int) ((Math.random() * 9 + 1) * 100000000));
        }

    }
}
