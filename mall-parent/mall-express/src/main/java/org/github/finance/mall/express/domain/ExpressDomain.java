package org.github.finance.mall.express.domain;

import org.github.finance.mall.account.domain.AccountAdressDomain;
import org.github.finance.mall.share.express.constance.ExpressStatusEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午12:50:24
 */
@Data
public class ExpressDomain {

    private String                expressRequestId;

    private String                userId;

    private String                userName;

    private String                userPhone;

    private String                orderId;

    private ExpressStatusEnum     expressStatusEnum;

    private AccountAdressDomain   accountAdressDomain;

    private ExpressProviderDomain expressProviderDomain;

    private ExpressCourierDomain  expressCourierDomain;
}
