package org.github.finance.mall.share.bank.dto;

import java.io.Serializable;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:51:13
 */
@NotNull
@Data
public class UnBindCardDTO implements Serializable {

    private static final long serialVersionUID = 3349102336938179899L;

    private String            userId;

    private String            bankAccountId;

}
