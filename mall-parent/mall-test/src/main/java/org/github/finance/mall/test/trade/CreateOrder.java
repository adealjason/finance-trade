package org.github.finance.mall.test.trade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.mall.product.domain.MarketRuleDomain;
import org.github.finance.mall.product.domain.ProductOfferingDomain;
import org.github.finance.mall.share.order.dto.OrderProductDTO;
import org.github.finance.mall.share.trade.request.CreateOrderRequest;
import org.github.finance.mall.share.trade.response.CreateOrderResponse;
import org.github.finance.mall.test.UserInfoGenerator;
import org.github.finance.mall.test.product.dataProvider.productOffering.Apple6sProductOffering;
import org.github.finance.mall.trade.ITransaction;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月16日 下午8:30:43
 */
@Slf4j
@Component
public class CreateOrder implements Runnable {

    @Resource
    private ITransaction<CreateOrderRequest, CreateOrderResponse> createOrderTransaction;

    @Override
    public void run() {
        while (true) {
            try {
                CreateOrderRequest createOrderRequest = this.generateCreateOrderRequest();
                createOrderTransaction.invoke(createOrderRequest);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private CreateOrderRequest generateCreateOrderRequest() {
        Map<String, String> dataMap = UserInfoGenerator.getData();
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setAddress(dataMap.get("address"));
        createOrderRequest.setAddressee(dataMap.get("name"));
        createOrderRequest.setAddresseePhone(dataMap.get("tel"));
        createOrderRequest.setApplyPurchaseDate(DateTime.now().toDate());
        createOrderRequest.setExpressPrivoderId("YUNDA");
        createOrderRequest.setUserId(dataMap.get("userId"));
        createOrderRequest.setZipCode(dataMap.get("zipCode"));
        List<OrderProductDTO> orderProductDTOList = Lists.newArrayList();
        orderProductDTOList.add(this.generateApple6s());
        createOrderRequest.setOrderProductDTOList(orderProductDTOList);
        return createOrderRequest;
    }

    private OrderProductDTO generateApple6s() {
        ProductOfferingDomain apple6sProductOffering = Apple6sProductOffering.getIntance();
        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setCurrency("RMB");
        orderProductDTO.setProductName(apple6sProductOffering.getProductOfferingName());
        orderProductDTO.setProductOfferingCode(apple6sProductOffering.getProductOfferingCode());
        orderProductDTO.setProductSize(3);
        orderProductDTO.setUnitPrice(new BigDecimal(6999));
        BigDecimal discountRate = BigDecimal.ZERO;
        MarketRuleDomain marketRuleDomain = apple6sProductOffering.getMarketRule("discount");
        if (marketRuleDomain != null) {
            Map<String, BigDecimal> extendJson = JSON.parseObject(marketRuleDomain.getExtendJson(),
                    new TypeReference<Map<String, BigDecimal>>() {
                    });
            if (extendJson.get(discountRate) != null) {
                discountRate = extendJson.get(discountRate);
            }
        }
        orderProductDTO.setDiscountRate(discountRate);
        return orderProductDTO;
    }

}
