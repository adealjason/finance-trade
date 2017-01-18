package org.github.finance.mall.account.impl;

import java.util.List;

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

import com.google.common.collect.Lists;

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
    @Resource(name = "userAccountLogEventCollector")
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
            public List<String> getMetaData() {
                List<String> dataList = Lists.newArrayListWithCapacity(5);
                dataList.add(userId);
                dataList.add(userRegisterDTO.getUserName());
                dataList.add(userRegisterDTO.getUserPhone());
                dataList.add(userRegisterDTO.getLogInName());
                dataList.add(String.valueOf(DateTime.now().toDate().getTime()));
                return dataList;
            }

            @Override
            public String getLogEvent() {
                return UserAccountLogEvent.REGISTER.name();
            }
        });
        return userId;
    }

    @Override
    public boolean logIn(final UserLogInDTO userLogIn) throws MallAccountException {

        final boolean isLogIn = userOnlineService.logIn(userLogIn.getLogInName(), userLogIn.getLogInPassword());

        userAccountLogEventCollector.collectData(new DataCollectorProvider() {
            @Override
            public List<String> getMetaData() {
                List<String> dataList = Lists.newArrayListWithCapacity(3);
                dataList.add(userLogIn.getLogInName());
                dataList.add(String.valueOf(isLogIn));
                dataList.add(String.valueOf(DateTime.now().toDate().getTime()));
                return dataList;
            }

            @Override
            public String getLogEvent() {
                return UserAccountLogEvent.LOGIN.name();
            }
        });
        return isLogIn;
    }

    @Override
    public boolean logOut(final LogOutDTO logOut) throws MallAccountException {
        final boolean isLogOut = userOnlineService.logOut(logOut.getLogInName());

        userAccountLogEventCollector.collectData(new DataCollectorProvider() {

            @Override
            public List<String> getMetaData() {
                List<String> dataList = Lists.newArrayListWithCapacity(3);
                dataList.add(logOut.getLogInName());
                dataList.add(String.valueOf(isLogOut));
                dataList.add(String.valueOf(DateTime.now().toDate().getTime()));
                return dataList;
            }

            @Override
            public String getLogEvent() {
                return UserAccountLogEvent.LOGOUT.name();
            }
        });
        return isLogOut;
    }

}
