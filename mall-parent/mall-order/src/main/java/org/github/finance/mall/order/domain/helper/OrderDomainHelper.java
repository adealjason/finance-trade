package org.github.finance.mall.order.domain.helper;

import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;

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
        return orderDomain;
    }

}
