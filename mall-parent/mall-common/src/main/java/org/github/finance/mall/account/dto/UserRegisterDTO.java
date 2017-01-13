package org.github.finance.mall.account.dto;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:14:26
 */
@Data
public class UserRegisterDTO {

    private String userName;

    private String logInName;

    @NotNull
    private String logInPassword;

    @NotNull
    private String userPhone;

}
