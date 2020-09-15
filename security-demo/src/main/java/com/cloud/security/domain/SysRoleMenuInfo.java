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
@Table(name = "sys_role_menu")
@EqualsAndHashCode(callSuper = false)
public class SysRoleMenuInfo extends BaseInfo {

    @Column(name = "role_id",columnDefinition="varchar(32) COMMENT '角色id'")
    private String roleId;

    @Column(name = "menu_id",columnDefinition="varchar(32) COMMENT '菜单id'")
    private String menuId;

}
