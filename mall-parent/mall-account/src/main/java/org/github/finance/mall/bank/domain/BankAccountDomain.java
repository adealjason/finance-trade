package org.github.finance.mall.bank.domain;

import java.util.Date;

import org.github.finance.mall.share.bank.constance.BindCardStatusEnum;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月14日 下午9:00:51
 */
@Data
public class BankAccountDomain {

    private String             userId;

    private String             bankAccountId;

    private String             certNo;

    private String             bankPhone;

    private String             bankName;

    private String             cardNo;

    private String             cardType;

    private BindCardStatusEnum status;

    private Date               expireDate;

}
