package com.cloud.security.dao;

import com.cloud.security.domain.SysUserRoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface SysUserRoleInfoRepository extends CrudRepository<SysUserRoleInfo, String>, JpaRepository<SysUserRoleInfo, String>,
        JpaSpecificationExecutor<SysUserRoleInfo> {

    @Query("select a from SysRoleInfo a inner join SysUserRoleInfo b on a.id = b.roleId " +
            "where b.userId = :userId")
    Set<SysUserRoleInfo> findRolesByUserId(@Param("userId") String userId);

    @Query("select a from SysRoleInfo a inner join SysUserRoleInfo b on a.id = b.roleId " +
            "where b.userId in ?1")
    Set<SysUserRoleInfo> findRolesByUserIds(Set<String> userIds);

    int deleteByUserId(String userId);
}
