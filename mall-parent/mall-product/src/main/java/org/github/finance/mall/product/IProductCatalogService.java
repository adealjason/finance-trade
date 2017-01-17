package org.github.finance.mall.product;

import org.github.finance.mall.product.domain.ProductCatalogDomain;
import org.github.finance.mall.product.exception.MallProductException;

/**
 * @author ligaofeng 2017年1月17日 上午10:24:34
 */
public interface IProductCatalogService {

    /**
     * @param productCatalogId
     * @return
     * @throws MallProductException
     */
    public ProductCatalogDomain getProductCatalog(String productCatalogId) throws MallProductException;
}
