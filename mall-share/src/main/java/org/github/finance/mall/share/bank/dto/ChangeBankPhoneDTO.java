package org.github.finance.mall.share.bank.dto;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:52:50
 */
@NotNull
@Data
public class ChangeBankPhoneDTO {

    private String userId;

    private String bankAccountId;

    private String sourceBankPhone;

    private String destBankPhone;

    private String verificationCode;
}
