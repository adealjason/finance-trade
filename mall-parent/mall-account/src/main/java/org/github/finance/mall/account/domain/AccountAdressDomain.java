package org.github.finance.mall.account.domain;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午8:39:45
 */
@Data
public class AccountAdressDomain {

    private String userId;

    private String address;

    private String zipCode;

    //收件人
    private String addressee;

    private String addresseePhone;
}
