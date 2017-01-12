package org.github.finance.mall.bank.vo;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:47:00
 */
@Data
public class BindCardVO {

    @NotNull
    private String userId;

    @NotNull
    private String cardNo;

    @NotNull
    private String bankPhone;

    @NotNull
    private String certNo;

    @NotNull
    private String verificationCode;

}
