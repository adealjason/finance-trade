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
import org.github.finance.mall.share.payment.dto.CreatePaymentDTO;
import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
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
    public String createOrder(CreateOrderDTO createOrderDTO) throws MallOrderException {
        try {
            OrderDomain orderDomain = OrderDomainHelper.toOrderDomain(createOrderDTO);
            //创建订单
            orderDomain.setOderStatus(OrderStatusEnum.NEW);
            orderRequestService.saveOrderRequest(orderDomain);
            //产品预售
            PreSaleDTO preSaleDTO = this.createPreSaleDTO(createOrderDTO, orderDomain.getOrderId());
            storeHourseService.preSale(preSaleDTO);
            //创建待支付流水
            CreatePaymentDTO createPaymentDTO = this.createPaymentDTO(createOrderDTO, orderDomain.getOrderId());
            paymentService.createPayment(createPaymentDTO);

            return orderDomain.getOrderId();
        } catch (Exception e) {
            throw new MallOrderException(e);
        }
    }

    private CreatePaymentDTO createPaymentDTO(CreateOrderDTO createOrderDTO, String orderId) {
        CreatePaymentDTO createPaymentDTO = new CreatePaymentDTO();
        createPaymentDTO.setUserId(createOrderDTO.getUserId());
        createPaymentDTO.setPaymentAmount(createOrderDTO.getPaymentAmount());
        createPaymentDTO.setProductOfferingCode(createOrderDTO.getProductOfferingCode());
        createPaymentDTO.setOrderId(orderId);
        return createPaymentDTO;
    }

    private PreSaleDTO createPreSaleDTO(CreateOrderDTO createOrderDTO, String orderId) {
        PreSaleDTO preSaleDTO = new PreSaleDTO();
        preSaleDTO.setApplyPurchaseDate(createOrderDTO.getApplyPurchaseDate());
        preSaleDTO.setOrderId(orderId);
        preSaleDTO.setProductOfferingCode(createOrderDTO.getProductOfferingCode());
        preSaleDTO.setSize(createOrderDTO.getOrderProductSize());
        preSaleDTO.setUserId(createOrderDTO.getUserId());
        return preSaleDTO;
    }

}
