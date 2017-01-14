package org.github.finance.mall.account.domain;

import lombok.Data;

/**
 * 用户登录信息
 * 
 * @author ligaofeng 2017年1月14日 下午8:36:20
 */
@Data
public class AccountPassportDomain {

    private String userId;

    private String userName;

    private String userPhone;

    private String logInName;

    private String logInPassword;

}
