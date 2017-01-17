package org.github.finance.mall.order.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.order.IOrderService;
import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.order.domain.helper.OrderDomainHelper;
import org.github.finance.mall.order.exception.MallOrderException;
import org.github.finance.mall.order.service.IOrderRequestService;
import org.github.finance.mall.payment.IPaymentService;
import org.github.finance.mall.share.order.constance.OrderLogEvent;
import org.github.finance.mall.share.order.constance.OrderStatusEnum;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;
import org.github.finance.mall.share.order.dto.OrderProductDTO;
import org.github.finance.mall.share.payment.dto.CreatePaymentDTO;
import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
import org.github.finance.mall.storehouse.IStoreHourseService;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

/**
 * @author ligaofeng 2017年1月15日 下午2:11:03
 */
@Service
public class OrderService implements IOrderService {

    @Resource
    private IOrderRequestService orderRequestService;
    @Resource
    private IStoreHourseService  storeHourseService;
    @Resource
    private IPaymentService      paymentService;
    @Resource(name = "orderLogEventCollector")
    private DataCollector        orderLogEventCollector;

    @Override
    public String createOrder(final CreateOrderDTO createOrderDTO) throws MallOrderException {
        try {
            OrderDomain orderDomain = OrderDomainHelper.toOrderDomain(createOrderDTO);
            //创建订单
            orderDomain.setOderStatus(OrderStatusEnum.NEW);
            orderRequestService.saveOrderRequest(orderDomain);

            final String orderId = orderDomain.getOrderId();
            //产品预售
            for (OrderProductDTO an : createOrderDTO.getOrderProductDTOList()) {
                PreSaleDTO preSaleDTO = this.createPreSaleDTO(createOrderDTO, orderId, an.getProductOfferingCode());
                storeHourseService.preSale(preSaleDTO);
            }
            //创建待支付流水
            CreatePaymentDTO createPaymentDTO = this.createPaymentDTO(createOrderDTO, orderId);
            paymentService.createPayment(createPaymentDTO);

            orderLogEventCollector.collectData(new DataCollectorProvider() {

                @Override
                public Map<String, String> getMetaData() {
                    Map<String, String> dataMap = Maps.newHashMap();
                    dataMap.put("userId", createOrderDTO.getUserId());
                    dataMap.put("orderId", orderId);
                    dataMap.put("applyPurchaseDate", String.valueOf(createOrderDTO.getApplyPurchaseDate().getTime()));
                    return dataMap;
                }

                @Override
                public String getLogEvent() {
                    return OrderLogEvent.CREATE_ORDER.name();
                }
            });

            return orderId;
        } catch (Exception e) {
            throw new MallOrderException(e);
        }
    }

    private CreatePaymentDTO createPaymentDTO(CreateOrderDTO createOrderDTO, String orderId) {
        CreatePaymentDTO createPaymentDTO = new CreatePaymentDTO();
        createPaymentDTO.setUserId(createOrderDTO.getUserId());
        createPaymentDTO.setPaymentAmount(createOrderDTO.getPaymentAmount());
        createPaymentDTO.setOrderId(orderId);
        return createPaymentDTO;
    }

    private PreSaleDTO createPreSaleDTO(CreateOrderDTO createOrderDTO, String orderId, String productOfferingCode) {
        PreSaleDTO preSaleDTO = new PreSaleDTO();
        preSaleDTO.setApplyPurchaseDate(createOrderDTO.getApplyPurchaseDate());
        preSaleDTO.setOrderId(orderId);
        preSaleDTO.setProductOfferingCode(productOfferingCode);
        preSaleDTO.setSize(createOrderDTO.getOrderProductSize());
        preSaleDTO.setUserId(createOrderDTO.getUserId());
        return preSaleDTO;
    }

}
