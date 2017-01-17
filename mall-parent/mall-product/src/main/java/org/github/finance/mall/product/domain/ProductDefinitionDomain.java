package org.github.finance.mall.product.domain;

import java.util.List;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:11:42
 */
@Data
public class ProductDefinitionDomain {

    private String                      productDifinitionId;

    private String                      productName;

    private String                      productCode;

    private String                      productCatalogId;

    private String                      status;

    private int                         showOrder;

    private List<ProductOfferingDomain> productOfferingDomainList;
}
