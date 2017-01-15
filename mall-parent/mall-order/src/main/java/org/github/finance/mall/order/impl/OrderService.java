package org.github.finance.mall.order.impl;

import javax.annotation.Resource;

import org.github.finance.mall.order.IOrderService;
import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.order.domain.helper.OrderDomainHelper;
import org.github.finance.mall.order.exception.MallOrderException;
import org.github.finance.mall.order.service.IOrderRequestService;
import org.github.finance.mall.payment.IPaymentService;
import org.github.finance.mall.share.order.constance.OrderStatusEnum;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;
import org.github.finance.mall.storehouse.IStoreHourseService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午2:11:03
 */
@Slf4j
@Service
public class OrderService implements IOrderService {

    @Resource
    private IOrderRequestService orderRequestService;
    @Resource
    private IStoreHourseService  storeHourseService;
    @Resource
    private IPaymentService      paymentService;

    @Override
    public void createOrder(CreateOrderDTO createOrderDTO) throws MallOrderException {
        OrderDomain orderDomain = OrderDomainHelper.toOrderDomain(createOrderDTO);
        //创建订单
        orderDomain.setOderStatus(OrderStatusEnum.NEW);
        orderRequestService.saveOrderRequest(orderDomain);
        //产品预售

        //创建待支付流水
    }

}
