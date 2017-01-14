package org.github.finance.mall.account.domain.helper;

import org.github.finance.mall.account.domain.AccountPassportDomain;
import org.github.finance.mall.share.account.dto.UserRegisterDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author ligaofeng 2017年1月14日 下午8:50:55
 */
public class AccountPassportDomainHelper {

    private AccountPassportDomainHelper() {
    }

    /**
     * @param userRegisterDTO
     * @return
     */
    public static AccountPassportDomain toAccountPassportDomain(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            return null;
        }
        AccountPassportDomain accountPassportDomain = new AccountPassportDomain();
        BeanUtils.copyProperties(userRegisterDTO, accountPassportDomain);
        return accountPassportDomain;
    }
}
