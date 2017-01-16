package org.github.finance.mall.order;

import org.github.finance.mall.order.exception.MallOrderException;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;

/**
 * @author ligaofeng 2017年1月13日 下午5:18:51
 */
public interface IOrderService {

    /**
     * 创建订单
     * 
     * @param createOrderDTO
     * @throws MallOrderException
     */
    public String createOrder(CreateOrderDTO createOrderDTO) throws MallOrderException;
}
