package org.github.finance.mall.account.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.account.IUserAccountService;
import org.github.finance.mall.account.domain.AccountPassportDomain;
import org.github.finance.mall.account.domain.helper.AccountPassportDomainHelper;
import org.github.finance.mall.account.exception.MallAccountException;
import org.github.finance.mall.account.service.IUserOnlineService;
import org.github.finance.mall.account.service.IUserService;
import org.github.finance.mall.share.account.constance.UserAccountLogEvent;
import org.github.finance.mall.share.account.dto.LogOutDTO;
import org.github.finance.mall.share.account.dto.UserLogInDTO;
import org.github.finance.mall.share.account.dto.UserRegisterDTO;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午4:56:31
 */
@Slf4j
@Service
public class UserAccountService implements IUserAccountService {

    @Resource
    private IUserService       userService;
    @Resource
    private IUserOnlineService userOnlineService;
    @Resource
    private DataCollector      userAccountLogEventCollector;

    @Override
    public String register(final UserRegisterDTO userRegisterDTO) throws MallAccountException {
        log.info("--->user {} register with loginName {} and userPhone {}", userRegisterDTO.getUserName(),
                userRegisterDTO.getLogInName(), userRegisterDTO.getUserPhone());
        AccountPassportDomain accountPassportDomain = AccountPassportDomainHelper
                .toAccountPassportDomain(userRegisterDTO);
        final String userId = userService.saveUser(accountPassportDomain);
        userAccountLogEventCollector.collectData(new DataCollectorProvider() {
            @Override
            public Map<String, Object> getMetaData() {
                Map<String, Object> dataMap = Maps.newHashMap();
                dataMap.put("userId", userId);
                dataMap.put("userName", userRegisterDTO.getUserName());
                dataMap.put("userPhone", userRegisterDTO.getUserPhone());
                dataMap.put("logInName", userRegisterDTO.getLogInName());
                dataMap.put("registerDate", DateTime.now().toDate());
                return dataMap;
            }

            @Override
            public String getLogEvent() {
                return UserAccountLogEvent.REGISTER.name();
            }
        });
        return userId;
    }

    @Override
    public boolean logIn(UserLogInDTO userLogIn) throws MallAccountException {

        return userOnlineService.logIn(userLogIn.getLogInName(), userLogIn.getLogInPassword());
    }

    @Override
    public boolean logOut(LogOutDTO logOut) throws MallAccountException {

        return userOnlineService.logOut(logOut.getLogInName());
    }

}
