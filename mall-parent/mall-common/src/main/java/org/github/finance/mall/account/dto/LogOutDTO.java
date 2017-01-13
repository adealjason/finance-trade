package org.github.finance.mall.account.dto;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午4:53:48
 */
@Data
public class LogOutDTO {

    @NotNull
    private String logInName;
}
