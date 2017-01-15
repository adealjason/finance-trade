package org.github.finance.mall.express.domain.helper;

import org.github.finance.mall.account.domain.AccountAdressDomain;
import org.github.finance.mall.express.domain.ExpressDomain;
import org.github.finance.mall.express.domain.ExpressProviderDomain;
import org.github.finance.mall.share.express.dto.CreateExpressDTO;

/**
 * @author ligaofeng 2017年1月15日 下午1:22:06
 */
public class ExpressDomainHelper {

    private ExpressDomainHelper() {
    }

    /**
     * @param createExpressDTO
     * @return
     */
    public static ExpressDomain toExpressDomain(CreateExpressDTO createExpressDTO) {
        ExpressDomain expressDomain = new ExpressDomain();
        expressDomain.setUserId(createExpressDTO.getUserId());
        expressDomain.setUserName(createExpressDTO.getUserName());
        expressDomain.setUserPhone(createExpressDTO.getUserPhone());

        AccountAdressDomain accountAdressDomain = new AccountAdressDomain();
        accountAdressDomain.setUserId(createExpressDTO.getUserId());
        accountAdressDomain.setZipCode(createExpressDTO.getZipCode());
        accountAdressDomain.setAddress(createExpressDTO.getAddress());
        accountAdressDomain.setAddressee(createExpressDTO.getAddressee());
        accountAdressDomain.setAddresseePhone(createExpressDTO.getAddresseePhone());
        expressDomain.setAccountAdressDomain(accountAdressDomain);

        ExpressProviderDomain expressProviderDomain = new ExpressProviderDomain();
        expressProviderDomain.setProviderId(createExpressDTO.getExpressProviderId());
        expressDomain.setExpressProviderDomain(expressProviderDomain);

        return expressDomain;
    }
}
