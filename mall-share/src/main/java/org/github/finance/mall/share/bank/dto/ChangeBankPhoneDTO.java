package org.github.finance.mall.share.bank.dto;

import java.io.Serializable;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:52:50
 */
@NotNull
@Data
public class ChangeBankPhoneDTO implements Serializable {

    private static final long serialVersionUID = -355018220196858572L;

    private String            userId;

    private String            bankAccountId;

    private String            sourceBankPhone;

    private String            destBankPhone;

    private String            verificationCode;
}
