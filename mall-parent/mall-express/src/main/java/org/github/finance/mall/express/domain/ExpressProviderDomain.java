package org.github.finance.mall.express.domain;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:01:23
 */
@Data
public class ExpressProviderDomain {

    private String providerId;

    private String providerName;

    private String providerCode;

    private String status;
}
