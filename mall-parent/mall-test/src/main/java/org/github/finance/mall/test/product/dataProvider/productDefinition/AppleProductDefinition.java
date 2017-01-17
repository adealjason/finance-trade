package org.github.finance.mall.test.product.dataProvider.productDefinition;

import java.util.List;

import org.github.finance.mall.product.domain.ProductDefinitionDomain;
import org.github.finance.mall.product.domain.ProductOfferingDomain;
import org.github.finance.mall.test.product.dataProvider.productCatalog.ElectronCatalog;
import org.github.finance.mall.test.product.dataProvider.productOffering.Apple6sProductOffering;

import com.google.common.collect.Lists;

/**
 * @author ligaofeng 2017年1月17日 上午11:28:04
 */
public class AppleProductDefinition extends ProductDefinitionDomain {

    private static final ProductDefinitionDomain appleProductDefinition = new AppleProductDefinition();

    static {
        appleProductDefinition.setProductCatalogId(ElectronCatalog.getIntance().getProductCatalogId());
        appleProductDefinition.setProductCode("apple");
        appleProductDefinition.setProductDifinitionId("apple");
        appleProductDefinition.setProductName("苹果");
        appleProductDefinition.setShowOrder(1);
        appleProductDefinition.setStatus("active");
        List<ProductOfferingDomain> productOfferingDomainList = Lists.newArrayList();
        productOfferingDomainList.add(Apple6sProductOffering.getIntance());
        appleProductDefinition.setProductOfferingDomainList(productOfferingDomainList);
    }

    public static ProductDefinitionDomain getIntance() {
        return appleProductDefinition;
    }
}
