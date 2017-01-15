package org.github.finance.mall.storehouse.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.github.finance.mall.share.storeHouse.constance.SaleStatusEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:50:03
 */
@Data
public class StoreHouseDomain {

    private String         userId;

    private String         orderId;

    private String         productOfferingCode;

    private BigDecimal     size;

    private Date           applyPurchaseDate;

    private SaleStatusEnum saleStatusEnum;
}
