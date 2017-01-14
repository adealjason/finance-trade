package org.github.finance.mall.account.domain;

import java.util.List;

import org.github.finance.mall.bank.domain.BankAccountDomain;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午8:32:06
 */
@Data
public class AccountDomian {

    private String                    userId;

    private String                    userName;

    private String                    userPhone;

    private AccountPassportDomain     accountPassportDomain;

    private List<AccountAdressDomain> accountAdressDomainList;

    private List<BankAccountDomain>   bankAccountDomain;

}
