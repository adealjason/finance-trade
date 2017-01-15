package org.github.finance.mall.express.dao.entity;

import java.util.Date;

import org.github.finance.mall.share.NotNull;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月15日 下午1:28:52
 */
@Data
public class ExpressRequestEntity {

    @NotNull
    private String id;

    @NotNull
    private String userId;

    private String userName;

    private String userPhone;

    @NotNull
    private String addressee;

    @NotNull
    private String addresseePhone;

    @NotNull
    private String address;

    private String zipCode;

    @NotNull
    private String expressProviderId;

    private String courierId;

    private String courierPhone;

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
