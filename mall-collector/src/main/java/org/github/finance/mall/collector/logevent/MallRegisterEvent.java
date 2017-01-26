package org.github.finance.mall.collector.logevent;

import org.github.finance.mall.collector.BaseLogEvent;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月21日 上午10:14:14
 */
@Data
public class MallRegisterEvent extends BaseLogEvent {

    private static final long serialVersionUID = 1156367673179093449L;

    private String            userId;

    private String            userName;

    private String            userPhone;

    private String            logInName;

    private String            registerDate;

    //手机地点:山东
    private String            province;

    //手机运营商:中国移动
    private String            catName;

    //运营商省份:山东移动
    private String            carrier;

}
