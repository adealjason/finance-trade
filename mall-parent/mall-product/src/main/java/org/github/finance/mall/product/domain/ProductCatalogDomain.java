package org.github.finance.mall.product.domain;

import java.util.List;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:12:44
 */
@Data
public class ProductCatalogDomain {

    private String                        id;

    private String                        catalog;

    private String                        status;

    private int                           showOrder;

    private List<ProductDefinitionDomain> productDefinitionDomainList;
}
