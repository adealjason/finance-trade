package org.github.finance.mall.share.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午5:20:44
 */
@NotNull
@Data
public class CreateOrderDTO implements Serializable {

    private static final long serialVersionUID = 1820046840793034051L;

    private String            userId;

    private String            addressee;

    private String            address;

    private String            addresseePhone;

    private String            zipCode;

    private String            expressId;

    private String            productOfferingCode;

    private BigDecimal        buyCopies;

}
