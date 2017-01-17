package org.github.finance.mall.test.account;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.mall.account.IUserAccountService;
import org.github.finance.mall.share.account.dto.LogOutDTO;
import org.github.finance.mall.share.account.dto.UserLogInDTO;
import org.github.finance.mall.test.UserInfoGenerator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午5:52:40
 */
@Slf4j
@Component
public class UserOnline implements Runnable {

    @Resource
    private IUserAccountService userAccountService;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1 * 1000l);
                UserLogInDTO userLogInDTO = this.generateUserLogInDTO();
                userAccountService.logIn(userLogInDTO);
                LogOutDTO logOut = this.generateLogOutDTO();
                userAccountService.logOut(logOut);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private UserLogInDTO generateUserLogInDTO() {
        UserLogInDTO userLogInDTO = new UserLogInDTO();
        Map<String, String> dataMap = UserInfoGenerator.getData();
        userLogInDTO.setLogInName(dataMap.get("tel"));
        userLogInDTO.setLogInPassword(dataMap.get("password"));
        return userLogInDTO;
    }

    private LogOutDTO generateLogOutDTO() {
        LogOutDTO logOut = new LogOutDTO();
        Map<String, String> dataMap = UserInfoGenerator.getData();
        logOut.setLogInName(dataMap.get("tel"));
        return logOut;
    }

}
