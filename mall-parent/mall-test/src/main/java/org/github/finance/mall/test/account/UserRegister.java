package org.github.finance.mall.test.account;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.mall.account.IUserAccountService;
import org.github.finance.mall.share.account.dto.UserRegisterDTO;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午4:00:01
 */
@Slf4j
@Component
public class UserRegister implements Runnable {

    @Resource
    private IUserAccountService userAccountService;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1 * 1000l);
                UserRegisterDTO userRegisterDTO = this.generateUserRegisterDTO();
                userAccountService.register(userRegisterDTO);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private UserRegisterDTO generateUserRegisterDTO() {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        Map<String, String> dataMap = UserInfoGenerator.getData();
        userRegisterDTO.setLogInName(dataMap.get("tel"));
        userRegisterDTO.setLogInPassword(dataMap.get("password"));
        userRegisterDTO.setUserName(dataMap.get("name"));
        userRegisterDTO.setUserPhone(dataMap.get("tel"));
        return userRegisterDTO;
    }

}
