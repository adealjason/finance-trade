package org.github.finance.mall.test.product;

import org.github.finance.mall.product.IProductDefinitionService;
import org.github.finance.mall.product.domain.ProductDefinitionDomain;
import org.github.finance.mall.product.exception.MallProductException;
import org.github.finance.mall.test.product.dataProvider.productDefinition.AppleProductDefinition;
import org.springframework.stereotype.Component;

/**
 * @author ligaofeng 2017年1月17日 上午11:48:05
 */
@Component
public class TestProductDefinitionService implements IProductDefinitionService {

    @Override
    public ProductDefinitionDomain getProductDefinition(String productDifinitionId) throws MallProductException {
        return AppleProductDefinition.getIntance();
    }

}
