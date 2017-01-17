package org.github.finance.mall.test.product;

import org.github.finance.mall.product.IProductOfferingService;
import org.github.finance.mall.product.domain.ProductOfferingDomain;
import org.github.finance.mall.product.exception.MallProductException;
import org.github.finance.mall.test.product.dataProvider.productOffering.Apple6sProductOffering;
import org.springframework.stereotype.Component;

/**
 * @author ligaofeng 2017年1月17日 上午11:45:35
 */
@Component
public class TestProductOfferingService implements IProductOfferingService {

    @Override
    public ProductOfferingDomain getProductOffering(String productOfferingCode) throws MallProductException {
        return Apple6sProductOffering.getIntance();
    }

}
