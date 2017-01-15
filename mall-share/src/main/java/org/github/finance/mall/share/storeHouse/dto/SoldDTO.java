package org.github.finance.mall.share.storeHouse.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:55:40
 */
@Data
public class SoldDTO implements Serializable {

    private static final long serialVersionUID = 7630757251536921836L;

    private String            preSaleId;

    private BigDecimal        paymentAmount;

    private Date              paymentSuccessDate;

}
