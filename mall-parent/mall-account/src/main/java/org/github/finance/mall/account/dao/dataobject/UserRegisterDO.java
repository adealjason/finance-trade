package org.github.finance.mall.account.dao.dataobject;

import java.util.Date;

import org.github.finance.mall.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午5:19:01
 */
@Data
public class UserRegisterDO {

    @NotNull
    private String userId;

    private String userName;

    private String logInName;

    @NotNull
    private String logInPassword;

    @NotNull
    private String userPhone;

    @NotNull
    private String isDeleted;

    @NotNull
    private String creator;

    @NotNull
    private String modifier;

    @NotNull
    private Date   gmtCreated;

    @NotNull
    private Date   gmtModified;

}
