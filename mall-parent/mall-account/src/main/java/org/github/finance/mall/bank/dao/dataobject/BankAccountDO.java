package org.github.finance.mall.bank.dao.dataobject;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午8:03:29
 */
@Data
public class BankAccountDO {

    @NotNull
    private String id;

    @NotNull
    private String userId;

}
