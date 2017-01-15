package org.github.finance.mall.order.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:16:10
 */
@NotNull
@Data
public class OrderEntity {

    private String     id;

    private int        orderProductSize;

    private BigDecimal orderAmout;

    private String     expressAmount;

    private String     currency;

    private String     status;

    //快递流水记录，通常一个订单一个快递单号
    private String     expressId;

    private String     paymentId;

    private String     isDeleted;

    private String     creator;

    private String     modifier;

    private Date       gmtCreated;

    private Date       gmtModified;
}
