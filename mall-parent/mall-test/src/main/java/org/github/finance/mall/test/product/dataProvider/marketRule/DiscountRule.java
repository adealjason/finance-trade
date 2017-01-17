package org.github.finance.mall.test.product.dataProvider.marketRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.github.finance.mall.product.domain.MarketRuleDomain;
import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;

/**
 * @author ligaofeng 2017年1月17日 上午10:48:49
 */
public class DiscountRule extends MarketRuleDomain {

    private static final MarketRuleDomain discountRule = new DiscountRule();

    static {
        Map<String, BigDecimal> extendJson = new HashMap<String, BigDecimal>();
        extendJson.put("discountRate", new BigDecimal(0.96));
        discountRule.setRuleId("discount");
        discountRule.setRuleName("优惠比例");
        discountRule.setStutus("active");
        discountRule.setRuleDesc("优惠比例");
        discountRule.setExtendJson(JSON.toJSONString(extendJson));
        discountRule.setStartDate(DateTime.now().withTimeAtStartOfDay().minusDays(1).toDate());
        discountRule.setEndDate(DateTime.now().withTimeAtStartOfDay().plusDays(2).toDate());
    }

    public static MarketRuleDomain getIntance() {
        return discountRule;
    }
}
