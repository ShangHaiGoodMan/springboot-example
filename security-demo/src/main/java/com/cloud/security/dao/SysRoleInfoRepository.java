package com.cloud.security.dao;

import com.cloud.security.domain.SysRoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface SysRoleInfoRepository extends CrudRepository<SysRoleInfo, String>, JpaRepository<SysRoleInfo, String>,
        JpaSpecificationExecutor<SysRoleInfo> {

    SysRoleInfo findByCode(String code);

}
