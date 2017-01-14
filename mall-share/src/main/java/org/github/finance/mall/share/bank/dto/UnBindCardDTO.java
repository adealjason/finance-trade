package org.github.finance.mall.share.bank.dto;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:51:13
 */
@NotNull
@Data
public class UnBindCardDTO {

    private String userId;

    private String bankAccountId;

}
