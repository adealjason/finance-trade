package org.github.finance.mall.bank.vo;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:52:50
 */
@NotNull
@Data
public class ChangeBankPhoneVO {

    private String userId;

    private String bankAccountId;

    private String sourceBankPhone;

    private String destBankPhone;

    private String verificationCode;
}
