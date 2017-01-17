package org.github.finance.mall.test.product.dataProvider.productCatalog;

import java.util.List;

import org.github.finance.mall.product.domain.ProductCatalogDomain;
import org.github.finance.mall.product.domain.ProductDefinitionDomain;
import org.github.finance.mall.test.product.dataProvider.productDefinition.AppleProductDefinition;

import com.google.common.collect.Lists;

/**
 * @author ligaofeng 2017年1月17日 上午11:25:23
 */
public class ElectronCatalog extends ProductCatalogDomain {

    private static final ProductCatalogDomain electronCatalog = new ElectronCatalog();

    static {
        electronCatalog.setProductCatalogId("electron");
        electronCatalog.setCatalog("垫资产品");
        electronCatalog.setShowOrder(1);
        electronCatalog.setStatus("avtive");
        List<ProductDefinitionDomain> productDefinitionDomainList = Lists.newArrayList();
        productDefinitionDomainList.add(AppleProductDefinition.getIntance());
        electronCatalog.setProductDefinitionDomainList(productDefinitionDomainList);
    }

    public static ProductCatalogDomain getIntance() {
        return electronCatalog;
    }
}
