package org.github.finance.mall.share.account.dto;

import java.io.Serializable;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:32:47
 */
@NotNull
@Data
public class UserLogInDTO implements Serializable {

    private static final long serialVersionUID = -6971479233847215584L;

    private String            logInName;

    private String            logInPassword;

}
