package org.github.finance.mall.share.order.dto;

import java.math.BigDecimal;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午5:20:44
 */
@Data
public class CreateOrderDTO {

    @NotNull
    private String     userId;

    @NotNull
    private String     addressee;

    @NotNull
    private String     address;

    @NotNull
    private String     addresseePhone;

    private String     zipCode;

    @NotNull
    private String     expressId;

    @NotNull
    private String     productOfferingCode;

    @NotNull
    private BigDecimal buyCopies;

}
