package org.github.finance.mall.share.bank.dto;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:47:00
 */
@NotNull
@Data
public class BindCardDTO {

    private String userId;

    private String cardNo;

    private String bankPhone;

    private String certNo;

}
