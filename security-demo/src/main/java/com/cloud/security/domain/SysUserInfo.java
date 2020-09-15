package com.cloud.security.domain;

import com.cloud.security.domain.base.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户信息表
 */
@Data
@Entity
@Table(name = "sys_user")
@EqualsAndHashCode(callSuper = false)
public class SysUserInfo extends BaseInfo {

    @Column(name = "username",columnDefinition="varchar(50) COMMENT '用户名'")
    private String username;

    @Column(name = "password",columnDefinition="varchar(128) COMMENT '密码'")
    private String password;

    @Column(name = "nickname",columnDefinition="varchar(255) COMMENT '昵称'")
    private String nickname;

    @Column(name = "enabled",columnDefinition="tinyint(1) COMMENT '状态'")
    private Boolean enabled;

}
