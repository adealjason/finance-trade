package org.github.finance.mall.product.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午9:56:57
 */
@Data
@NotNull
public class MarketRuleEntity {

    private String id;

    private String ruleName;

    private String ruleDesc;

    private Date   startDate;

    private Date   endDate;

    private String stutus;

    private String extendJson;

    private String isDeleted;

    private String creator;

    private String modifier;

    private Date   gmtCreated;

    private Date   gmtModified;
}
