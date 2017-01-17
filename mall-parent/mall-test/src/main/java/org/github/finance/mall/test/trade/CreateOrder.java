package org.github.finance.mall.test.trade;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.mall.share.trade.request.CreateOrderRequest;
import org.github.finance.mall.share.trade.response.CreateOrderResponse;
import org.github.finance.mall.test.UserInfoGenerator;
import org.github.finance.mall.trade.ITransaction;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

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

        return createOrderRequest;
    }

}
