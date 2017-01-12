package org.github.finance.mall.account.entity;

import java.util.List;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午3:18:33
 */
@Data
public class UserEntity {

    private String                  userId;

    private String                  userName;

    private String                  logInName;

    private String                  logInPassword;

    private String                  userPhone;

    private List<BankAccountEntity> bankAccountEntity;

}
