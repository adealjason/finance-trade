package org.github.finance.mall.bank.vo;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:51:13
 */
@Data
public class UnBindCardVO {

    @NotNull
    private String userId;

    @NotNull
    private String bankAccountId;

    @NotNull
    private String verificationCode;
}
