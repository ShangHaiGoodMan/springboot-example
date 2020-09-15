package com.cloud.security.dao;

import com.cloud.security.domain.SysMenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface SysMenuInfoRepository extends CrudRepository<SysMenuInfo, String>, JpaRepository<SysMenuInfo, String>,
        JpaSpecificationExecutor<SysMenuInfo> {


    @Query("select a from SysMenuInfo a inner join SysRoleMenuInfo b on a.id = b.menuId " +
            "where b.roleId in ?1")
    Set<SysMenuInfo> findByRoleIds(Set<String> roleIds);

    @Query("select a.id from SysMenuInfo a inner join SysRoleMenuInfo b on a.id = b.menuId " +
            "where b.roleId = ?1")
    Set<String> findByOneRoleId(String roleId);

    List<SysMenuInfo> findByAuthority(String authority);

    List<SysMenuInfo> findByParentId(Integer parentId);

    @Modifying
    @Transactional
    int deleteByParentId(String parentId);

}
