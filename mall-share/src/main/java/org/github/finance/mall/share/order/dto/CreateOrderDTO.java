package org.github.finance.mall.share.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月13日 下午5:20:44
 */
@NotNull
@Data
public class CreateOrderDTO implements Serializable {

    private static final long     serialVersionUID = 1820046840793034051L;

    private String                userId;

    private String                addressee;

    private String                address;

    private String                addresseePhone;

    private String                zipCode;

    private String                expressPrivoderId;

    private Date                  applyPurchaseDate;

    private List<OrderProductDTO> orderProductDTOList;

    /**
     * @return
     */
    public int getOrderProductSize() {
        if (CollectionUtils.isEmpty(orderProductDTOList)) {
            return 0;
        }
        int size = 0;
        for (OrderProductDTO an : orderProductDTOList) {
            size += an.getProductSize();
        }
        return size;
    }

    /**
     * @return
     */
    public BigDecimal getPaymentAmount() {
        if (CollectionUtils.isEmpty(orderProductDTOList)) {
            return BigDecimal.ZERO;
        }
        BigDecimal paymentAmount = BigDecimal.ZERO;
        //逐个商品累加
        for (OrderProductDTO an : orderProductDTOList) {
            BigDecimal currentAmount = new BigDecimal(an.getProductSize()).multiply(an.getUnitPrice());
            if (an.getDiscountRate() != null) {
                currentAmount = currentAmount.multiply(an.getDiscountRate());
            }
            paymentAmount = paymentAmount.add(currentAmount);
        }

        return paymentAmount;
    }

}
