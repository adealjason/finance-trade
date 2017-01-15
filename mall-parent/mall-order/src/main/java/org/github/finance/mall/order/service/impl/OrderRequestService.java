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
        log.info("--->save order request:{}", orderDomain);

        orderDomain.setOrderId(OrderIdGenerator.generateOrderId());
    }

    /**
     * 用户id
     * 
     * @author ligaofeng 2017年1月12日 下午5:34:33
     */
    private static class OrderIdGenerator {

        /**
         * @return
         */
        public static String generateOrderId() {

            return String.valueOf((int) ((Math.random() * 9 + 1) * 100000000));
        }

    }

}
