package org.github.finance.mall.product;

import org.github.finance.mall.product.domain.ProductDefinitionDomain;
import org.github.finance.mall.product.exception.MallProductException;

/**
 * @author ligaofeng 2017年1月17日 上午10:23:06
 */
public interface IProductDefinitionService {

    /**
     * 查询指定产品
     * 
     * @param productDifinitionId
     * @return
     * @throws MallProductException
     */
    public ProductDefinitionDomain getProductDefinition(String productDifinitionId) throws MallProductException;
}
