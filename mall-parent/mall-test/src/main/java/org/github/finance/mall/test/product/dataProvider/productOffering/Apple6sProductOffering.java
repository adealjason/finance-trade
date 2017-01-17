package org.github.finance.mall.test.product.dataProvider.productOffering;

import java.util.List;

import org.github.finance.mall.product.domain.MarketRuleDomain;
import org.github.finance.mall.product.domain.ProductOfferingDomain;
import org.github.finance.mall.product.domain.ProductPaymentDomain;
import org.github.finance.mall.test.product.dataProvider.marketRule.DiscountRule;
import org.github.finance.mall.test.product.dataProvider.payment.Apple6sChinaPayPayment;
import org.github.finance.mall.test.product.dataProvider.productDefinition.AppleProductDefinition;

import com.google.common.collect.Lists;

/**
 * @author ligaofeng 2017年1月17日 上午11:12:30
 */
public class Apple6sProductOffering extends ProductOfferingDomain {

    private static final ProductOfferingDomain apple6sProductOffering = new Apple6sProductOffering();

    static {
        apple6sProductOffering.setCapacity(Integer.MAX_VALUE);
        apple6sProductOffering.setProductDefinitionId(AppleProductDefinition.getIntance().getProductDifinitionId());
        apple6sProductOffering.setProductOfferingCode("apple6s");
        apple6sProductOffering.setProductOfferingName("苹果6s");
        apple6sProductOffering.setStutus("active");
        List<MarketRuleDomain> marketRuleDomainList = Lists.newArrayList();
        marketRuleDomainList.add(DiscountRule.getIntance());
        apple6sProductOffering.setMarketRuleDomainList(marketRuleDomainList);
        List<ProductPaymentDomain> productPaymentDomainList = Lists.newArrayList();
        productPaymentDomainList.add(Apple6sChinaPayPayment.getIntance());
        apple6sProductOffering.setProductPaymentDomainList(productPaymentDomainList);
    }

    public static ProductOfferingDomain getIntance() {
        return apple6sProductOffering;
    }
}
