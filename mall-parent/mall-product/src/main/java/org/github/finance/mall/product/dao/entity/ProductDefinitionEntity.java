package org.github.finance.mall.product.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午9:52:55
 */
@Data
@NotNull
public class ProductDefinitionEntity {

    private String id;

    private String productName;

    private String productCode;

    private String productCatalogId;

    private String status;

    private String showOrder;

    private String isDeleted;

    private String creator;

    private String modifier;

    private Date   gmtCreated;

    private Date   gmtModified;
}
