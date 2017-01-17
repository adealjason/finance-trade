package org.github.finance.mall.test.product.dataProvider;

import org.github.finance.mall.product.IProductCatalogService;
import org.github.finance.mall.product.domain.ProductCatalogDomain;
import org.github.finance.mall.product.exception.MallProductException;
import org.github.finance.mall.test.product.dataProvider.productCatalog.ElectronCatalog;

/**
 * @author ligaofeng 2017年1月17日 上午11:49:14
 */
public class TestProductCatalogService implements IProductCatalogService {

    @Override
    public ProductCatalogDomain getProductCatalog(String productCatalogId) throws MallProductException {
        return ElectronCatalog.getIntance();
    }

}
