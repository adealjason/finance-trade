package org.github.finance.mall.order.service.impl;

import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.order.exception.MallOrderException;
import org.github.finance.mall.order.service.IOrderRequestService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午2:15:55
 */
@Slf4j
@Service
public class OrderRequestService implements IOrderRequestService {

    @Override
    public void saveOrderRequest(OrderDomain orderDomain) throws MallOrderException {

    }

}
