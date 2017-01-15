package org.github.finance.mall.share.express.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:11:57
 */
@Data
public class CreateExpressDTO implements Serializable {

    private static final long serialVersionUID = -7256689626800268977L;

    private String            userId;

    private String            userName;

    private String            userPhone;

    //收件人
    private String            addressee;

    private String            addresseePhone;

    private String            address;

    private String            zipCode;

    //快递提供商
    private String            expressProviderId;

}
