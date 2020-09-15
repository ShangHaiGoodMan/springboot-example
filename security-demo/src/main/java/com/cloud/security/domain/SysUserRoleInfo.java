package com.cloud.security.domain;

import com.cloud.security.domain.base.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色 菜单功能表
 */
@Data
@Entity
@Table(name = "sys_user_role")
@EqualsAndHashCode(callSuper = false)
public class SysUserRoleInfo extends BaseInfo {

    @Column(name = "user_id",columnDefinition="varchar(32) COMMENT '用户id'")
    private String userId;

    @Column(name = "role_id",columnDefinition="varchar(32) COMMENT '角色id'")
    private String roleId;

}
