package org.github.finance.mall.product.domain;

import java.util.Date;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午11:01:22
 */
@Data
public class MarketRuleDomain {

    private String ruleName;

    private String ruleDesc;

    private Date   startDate;

    private Date   endDate;

    private String stutus;

    private String extendJson;
}
