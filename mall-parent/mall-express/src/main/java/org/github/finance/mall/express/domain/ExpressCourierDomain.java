package org.github.finance.mall.express.domain;

import lombok.Data;

/**
 * 快递员
 * 
 * @author ligaofeng 2017年1月15日 下午1:04:19
 */
@Data
public class ExpressCourierDomain {

    private String courierId;

    private String courierName;

    private String courierCode;

    private String courierPhone;
}
