package org.github.finance.mall.share.trade.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.github.finance.mall.share.order.dto.OrderProductDTO;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午8:08:51
 */
@Data
public class CreateOrderRequest implements Serializable {

    private static final long     serialVersionUID = -3218306504177880188L;

    private String                userId;

    private String                addressee;

    private String                address;

    private String                addresseePhone;

    private String                zipCode;

    private String                expressPrivoderId;

    private String                productOfferingCode;

    private Date                  applyPurchaseDate;

    private List<OrderProductDTO> orderProductDTOList;

}
