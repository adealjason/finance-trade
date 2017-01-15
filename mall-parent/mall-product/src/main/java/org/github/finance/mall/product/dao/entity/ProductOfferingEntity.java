package org.github.finance.mall.product.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午9:55:08
 */
@Data
@NotNull
public class ProductOfferingEntity {

    private String id;

    private String productOfferingCode;

    private String productOfferingName;

    private String productDefinitionId;

    private String stutus;

    private String isDeleted;

    private String creator;

    private String modifier;

    private Date   gmtCreated;

    private Date   gmtModified;
}
