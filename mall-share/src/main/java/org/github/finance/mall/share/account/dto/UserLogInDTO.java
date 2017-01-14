package org.github.finance.mall.share.account.dto;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:32:47
 */
@Data
public class UserLogInDTO {

    @NotNull
    private String logInName;

    @NotNull
    private String logInPassword;

}
