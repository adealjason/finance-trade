package org.github.finance.mall.share.bank.dto;

import java.io.Serializable;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午7:47:00
 */
@NotNull
@Data
public class BindCardDTO implements Serializable {

    private static final long serialVersionUID = 8033493173742220632L;

    private String            userId;

    private String            cardNo;

    private String            bankPhone;

    private String            certNo;

}
