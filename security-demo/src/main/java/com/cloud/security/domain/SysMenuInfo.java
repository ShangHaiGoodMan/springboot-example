package com.cloud.security.domain;

import com.cloud.security.domain.base.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 左边菜单和按钮 权限说明表
 */
@Data
@Entity
@Table(name = "sys_menu")
@EqualsAndHashCode(callSuper = false)
public class SysMenuInfo extends BaseInfo {

    @Column(name = "parent_id", columnDefinition="varchar(32) COMMENT '父Id'")
    private String parentId;

    @Column(name = "name", columnDefinition="varchar(32) COMMENT '功能名称'")
    private String name;

    @Column(name = "permission", columnDefinition="varchar(32) COMMENT '权限'")
    private String permission;

    @Column(name = "path", columnDefinition="varchar(128) COMMENT '地址'")
    private String path;

    @Column(name = "type", columnDefinition="varchar(2) COMMENT '类型'")
    private String type;

    @Column(name = "sort", columnDefinition="int(11) COMMENT '排序'")
    private Integer sort;

}
