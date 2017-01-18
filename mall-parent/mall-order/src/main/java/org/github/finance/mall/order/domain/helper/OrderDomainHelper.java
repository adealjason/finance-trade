package org.github.finance.mall.order.domain.helper;

import java.math.BigDecimal;

import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月15日 下午2:18:42
 */
public class OrderDomainHelper {

    private OrderDomainHelper() {
    }

    /**
     * @param createOrderDTO
     * @return
     */
    public static OrderDomain toOrderDomain(CreateOrderDTO createOrderDTO) {
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setUserId(createOrderDTO.getUserId());
        orderDomain.setOrderProductSize(createOrderDTO.getOrderProductSize());
        orderDomain.setOrderAmout(createOrderDTO.getPaymentAmount());
        orderDomain.setExpressAmount(BigDecimal.ZERO);
        orderDomain.setOutTime(DateTime.now().withTimeAtStartOfDay().plusHours(18).toDate());
        return orderDomain;
    }

}
