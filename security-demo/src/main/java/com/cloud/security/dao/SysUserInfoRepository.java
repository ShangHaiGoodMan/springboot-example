package com.cloud.security.dao;

import com.cloud.security.domain.SysUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


public interface SysUserInfoRepository extends CrudRepository<SysUserInfo, String>, JpaRepository<SysUserInfo, String>,
        JpaSpecificationExecutor<SysUserInfo> {

    SysUserInfo findByUsername(String username);

    SysUserInfo findByPhone(String phone);
}
