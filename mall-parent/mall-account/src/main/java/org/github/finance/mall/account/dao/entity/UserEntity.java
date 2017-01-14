package org.github.finance.mall.account.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月12日 下午5:19:01
 */
@Data
public class UserEntity {

    @NotNull
    private String id;

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
