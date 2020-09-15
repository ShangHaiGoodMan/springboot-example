package com.cloud.security.domain;

import com.cloud.security.domain.base.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色表
 */
@Data
@Entity
@Table(name = "sys_role")
@EqualsAndHashCode(callSuper = false)
public class SysRoleInfo extends BaseInfo {

    @Column(name = "code",columnDefinition="varchar(32) COMMENT '编码'")
    private String code;

    @Column(name = "name",columnDefinition="varchar(50) COMMENT '名称'")
    private String name;

    @Column(name = "remark", columnDefinition = "varchar(256) comment '描述'")
    private String remark;

}
