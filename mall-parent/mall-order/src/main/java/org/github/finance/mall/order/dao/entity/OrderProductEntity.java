package org.github.finance.mall.order.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:22:58
 */
@NotNull
@Data
public class OrderProductEntity {

    private String     id;

    private String     orderId;

    private String     productOfferingCode;

    private String     productName;

    private int        productSize;

    //折扣比例
    private BigDecimal discountRate;

    private BigDecimal sumAmount;

    private String     currency;

    private String     isDeleted;

    private String     creator;

    private String     modifier;

    private Date       gmtCreated;

    private Date       gmtModified;

}
