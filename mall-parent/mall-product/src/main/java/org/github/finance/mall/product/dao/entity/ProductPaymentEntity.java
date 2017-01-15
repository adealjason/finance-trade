package org.github.finance.mall.product.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午10:03:29
 */
@NotNull
@Data
public class ProductPaymentEntity {

    private String id;

    private String productOfferingCode;

    private String paymentWay;

    private String status;

    private String isDeleted;

    private String creator;

    private String modifier;

    private Date   gmtCreated;

    private Date   gmtModified;
}
