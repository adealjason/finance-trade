package org.github.finance.mall.product.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午9:45:02
 */
@NotNull
@Data
public class ProductCatalogEntity {

    private String id;

    private String catalog;

    private String status;

    private int    showOrder;

    private String isDeleted;

    private String creator;

    private String modifier;

    private Date   gmtCreated;

    private Date   gmtModified;

}
