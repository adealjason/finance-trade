package org.github.finance.mall.test.product.dataProvider.marketRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.github.finance.mall.product.domain.MarketRuleDomain;
import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;

/**
 * @author ligaofeng 2017年1月17日 上午10:30:46
 */
public class MaxPurchasePerDateRule extends MarketRuleDomain {

    private static final MarketRuleDomain maxPurchasePerDateRule = new MaxPurchasePerDateRule();

    static {
        Map<String, BigDecimal> extendJson = new HashMap<String, BigDecimal>();
        extendJson.put("amount", new BigDecimal(100));
        maxPurchasePerDateRule.setRuleId("maxPurchasePerDate");
        maxPurchasePerDateRule.setRuleName("单日最大可购买金额");
        maxPurchasePerDateRule.setStutus("active");
        maxPurchasePerDateRule.setRuleDesc("单日最大可购买金额");
        maxPurchasePerDateRule.setExtendJson(JSON.toJSONString(extendJson));
        maxPurchasePerDateRule.setStartDate(DateTime.now().withTimeAtStartOfDay().minusDays(1).toDate());
        maxPurchasePerDateRule.setEndDate(DateTime.now().withTimeAtStartOfDay().plusYears(1).toDate());
    }

    public static MarketRuleDomain getIntance() {
        return maxPurchasePerDateRule;
    }

}
