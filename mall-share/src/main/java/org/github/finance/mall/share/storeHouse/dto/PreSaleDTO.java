package org.github.finance.mall.share.storeHouse.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:50:03
 */
@Data
public class PreSaleDTO implements Serializable {

    private static final long serialVersionUID = 8708233914198474557L;

    private String            userId;

    private String            orderId;

    private String            productOfferingCode;

    private BigDecimal        size;

    private Date              applyPurchaseDate;
}
