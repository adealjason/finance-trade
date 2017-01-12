package org.github.finance.mall.bank.vo;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:52:50
 */
@Data
public class ChangeBankPhoneVO {

    @NotNull
    private String userId;

    @NotNull
    private String bankAccountId;

    @NotNull
    private String sourceBankPhone;

    @NotNull
    private String destBankPhone;

    @NotNull
    private String verificationCode;
}
