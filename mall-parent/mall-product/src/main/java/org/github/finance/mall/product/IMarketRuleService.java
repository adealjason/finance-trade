package org.github.finance.mall.product;

import java.util.List;

import org.github.finance.mall.product.domain.MarketRuleDomain;
import org.github.finance.mall.product.exception.MallProductException;

/**
 * @author ligaofeng 2017年1月17日 上午10:25:39
 */
public interface IMarketRuleService {

    /**
     * 查询产品的营销规则
     * 
     * @param productOfferingCode
     * @return
     * @throws MallProductException
     */
    public List<MarketRuleDomain> getMarketRule(String productOfferingCode) throws MallProductException;
}
