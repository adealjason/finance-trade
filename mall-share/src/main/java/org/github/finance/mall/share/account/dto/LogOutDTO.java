package org.github.finance.mall.share.account.dto;

import java.io.Serializable;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:53:48
 */
@Data
public class LogOutDTO implements Serializable {

    private static final long serialVersionUID = 918760190930159891L;

    @NotNull
    private String            logInName;
}
