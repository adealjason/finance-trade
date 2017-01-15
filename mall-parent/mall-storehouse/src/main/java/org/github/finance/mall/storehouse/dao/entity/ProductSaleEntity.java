package org.github.finance.mall.storehouse.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:58:38
 */
@Data
public class ProductSaleEntity {

    private String     id;

    private String     userId;

    private String     orderId;

    private String     productOfferingCode;

    private BigDecimal size;

    private Date       applyPurchaseDate;

    private BigDecimal paymentAmount;

    private Date       paymentSuccessDate;

    @NotNull
    private String     isDeleted;

    @NotNull
    private String     creator;

    @NotNull
    private String     modifier;

    @NotNull
    private Date       gmtCreated;

    @NotNull
    private Date       gmtModified;
}
