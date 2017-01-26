package org.github.finance.mall.order.impl;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.express.IExpressService;
import org.github.finance.mall.order.IOrderService;
import org.github.finance.mall.order.domain.OrderDomain;
import org.github.finance.mall.order.domain.helper.OrderDomainHelper;
import org.github.finance.mall.order.exception.MallOrderException;
import org.github.finance.mall.order.service.IOrderRequestService;
import org.github.finance.mall.payment.IPaymentService;
import org.github.finance.mall.share.express.dto.CreateExpressDTO;
import org.github.finance.mall.share.order.constance.OrderLogEvent;
import org.github.finance.mall.share.order.constance.OrderStatusEnum;
import org.github.finance.mall.share.order.dto.CreateOrderDTO;
import org.github.finance.mall.share.order.dto.OrderProductDTO;
import org.github.finance.mall.share.payment.dto.CreatePaymentDTO;
import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
import org.github.finance.mall.storehouse.IStoreHourseService;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

/**
 * @author ligaofeng 2017年1月15日 下午2:11:03
 */
@Service
public class OrderService implements IOrderService {

    @Resource
    private IOrderRequestService                    orderRequestService;
    @Resource
    private IStoreHourseService                     storeHourseService;
    @Resource
    private IPaymentService                         paymentService;
    @Resource
    private IExpressService                         expressService;
    @Resource(name = "orderLogEventCollector")
    private DataCollector                           orderLogEventCollector;

    private static final ThreadLocal<DecimalFormat> local = new ThreadLocal<DecimalFormat>() {

                                                              @Override
                                                              protected DecimalFormat initialValue() {
                                                                  super.initialValue();
                                                                  return new DecimalFormat("#0.00");
                                                              }
                                                          };

    @Override
    public String createOrder(final CreateOrderDTO createOrderDTO) throws MallOrderException {
        try {
            final OrderDomain orderDomain = OrderDomainHelper.toOrderDomain(createOrderDTO);
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

            //产生待发送快递订单
            CreateExpressDTO createExpressDTO = this.createExpressDTO(createOrderDTO, orderId);
            expressService.createExpress(createExpressDTO);

            orderLogEventCollector.collectData(new DataCollectorProvider() {

                @Override
                public List<String> getMetaData() {
                    List<String> dataList = Lists.newArrayListWithCapacity(5);
                    dataList.add(createOrderDTO.getUserId());
                    dataList.add(createOrderDTO.getUserPhone());
                    dataList.add(orderId);
                    dataList.add(local.get().format(orderDomain.getOrderAmout()));
                    dataList.add(String.valueOf(orderDomain.getOrderProductSize()));
                    dataList.add(String.valueOf(createOrderDTO.getApplyPurchaseDate().getTime()));
                    return dataList;
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

    private CreateExpressDTO createExpressDTO(CreateOrderDTO createOrderDTO, String orderId) {
        CreateExpressDTO createExpressDTO = new CreateExpressDTO();
        createExpressDTO.setAddress(createOrderDTO.getAddress());
        createExpressDTO.setAddressee(createOrderDTO.getAddressee());
        createExpressDTO.setAddresseePhone(createOrderDTO.getAddresseePhone());
        createExpressDTO.setExpressProviderId(createOrderDTO.getExpressProviderId());
        createExpressDTO.setOrderId(orderId);
        createExpressDTO.setUserId(createOrderDTO.getUserId());
        createExpressDTO.setZipCode(createOrderDTO.getZipCode());
        return createExpressDTO;
    }

    private CreatePaymentDTO createPaymentDTO(CreateOrderDTO createOrderDTO, String orderId) {
        CreatePaymentDTO createPaymentDTO = new CreatePaymentDTO();
        createPaymentDTO.setUserId(createOrderDTO.getUserId());
        createPaymentDTO.setPaymentAmount(createOrderDTO.getPaymentAmount());
        createPaymentDTO.setOrderId(orderId);
        createPaymentDTO.setApplyPaymentTime(createOrderDTO.getApplyPurchaseDate());
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
