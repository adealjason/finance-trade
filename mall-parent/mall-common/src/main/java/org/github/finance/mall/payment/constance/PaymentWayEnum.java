package org.github.finance.mall.payment.constance;

import lombok.Getter;

/**
 * @author ligaofeng 2017年1月13日 下午1:06:53
 */
public enum PaymentWayEnum {

    CHINA_PAY("chinaPaymentWay"),

    WEIXIN("weiXinPaymentWay"),

    ZHIFUBAO("zhifubaoPaymentWay"),

    DIANZI_ZHANGHU("dzzhhPaymentWay");

    @Getter
    private String beanId;

    private PaymentWayEnum(String beanId) {
        this.beanId = beanId;
    }
}
