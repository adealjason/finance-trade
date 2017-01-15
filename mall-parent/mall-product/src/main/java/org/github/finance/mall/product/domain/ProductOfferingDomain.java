package org.github.finance.mall.product.domain;

import java.util.List;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午10:07:58
 */
@Data
public class ProductOfferingDomain {

    private String                     productOfferingCode;

    private String                     productOfferingName;

    private String                     productDefinitionId;

    private String                     stutus;

    //在售容量
    private int                        capacity;

    private List<MarketRuleDomain>     marketRuleDomainList;

    private List<ProductPaymentDomain> productPaymentDomainList;
}
