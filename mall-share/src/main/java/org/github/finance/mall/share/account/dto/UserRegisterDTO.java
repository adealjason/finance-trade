package org.github.finance.mall.share.account.dto;

import java.io.Serializable;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:14:26
 */
@Data
public class UserRegisterDTO implements Serializable {

    private static final long serialVersionUID = 6331347565122606855L;

    private String            userName;

    private String            userPhone;

    @NotNull
    private String            logInName;

    @NotNull
    private String            logInPassword;

}
