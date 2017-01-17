package org.github.finance.mall.product;

import org.github.finance.mall.product.domain.ProductOfferingDomain;
import org.github.finance.mall.product.exception.MallProductException;

/**
 * @author ligaofeng 2017年1月17日 上午10:20:21
 */
public interface IProductOfferingService {

    /**
     * 查询指定产品
     * 
     * @param productOfferingCode
     * @return
     * @throws MallProductException
     */
    public ProductOfferingDomain getProductOffering(String productOfferingCode) throws MallProductException;
}
