package org.github.finance.mall.test.product.dataProvider.marketRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.github.finance.mall.product.domain.MarketRuleDomain;
import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;

/**
 * @author ligaofeng 2017年1月17日 上午10:43:32
 */
public class MaxPurchaseRule extends MarketRuleDomain {

    private static final MarketRuleDomain maxPurchaseRule = new MaxPurchasePerDateRule();

    static {
        Map<String, BigDecimal> extendJson = new HashMap<String, BigDecimal>();
        extendJson.put("amount", new BigDecimal(1000000));
        maxPurchaseRule.setRuleId("maxPurchase");
        maxPurchaseRule.setRuleName("最大可购买金额");
        maxPurchaseRule.setStutus("active");
        maxPurchaseRule.setRuleDesc("最大可购买金额");
        maxPurchaseRule.setExtendJson(JSON.toJSONString(extendJson));
        maxPurchaseRule.setStartDate(DateTime.now().withTimeAtStartOfDay().minusDays(1).toDate());
        maxPurchaseRule.setEndDate(DateTime.now().withTimeAtStartOfDay().plusYears(1).toDate());
    }

    public static MarketRuleDomain getIntance() {
        return maxPurchaseRule;
    }
}
