package org.github.finance.mall.order.service;

import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.order.exception.MallOrderException;

/**
 * @author ligaofeng 2017年1月15日 下午2:14:39
 */
public interface IOrderRequestService {

    /**
     * 创建订单
     * 
     * @param orderDomain
     * @throws MallOrderException
     */
    public void saveOrderRequest(OrderDomain orderDomain) throws MallOrderException;
}
