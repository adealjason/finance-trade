package org.github.finance.mall.account.vo;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:32:47
 */
@Data
public class UserLogInVO {

    @NotNull
    private String logInName;

    @NotNull
    private String logInPassword;

    @NotNull
    private String verificationCode;

}
