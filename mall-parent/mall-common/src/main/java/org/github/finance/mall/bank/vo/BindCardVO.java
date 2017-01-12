package org.github.finance.mall.bank.vo;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:47:00
 */
@NotNull
@Data
public class BindCardVO {

    private String userId;

    private String cardNo;

    private String bankPhone;

    private String certNo;

    private String verificationCode;

}
