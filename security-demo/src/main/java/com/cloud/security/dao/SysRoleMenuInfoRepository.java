package com.cloud.security.dao;

import com.cloud.security.domain.SysRoleMenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SysRoleMenuInfoRepository extends CrudRepository<SysRoleMenuInfo, String>, JpaRepository<SysRoleMenuInfo, String>,
        JpaSpecificationExecutor<SysRoleMenuInfo> {

    @Modifying
    @Transactional
    int deleteByRoleId(String roleId);

    @Modifying
    @Transactional
    @Query("delete from SysRoleMenuInfo a where a.roleId in ?1")
    int deleteByRoleIds(String[] roleIds);

    @Modifying
    @Transactional
    int deleteByRoleIdAndMenuId(String roleId, String menuId);
}
