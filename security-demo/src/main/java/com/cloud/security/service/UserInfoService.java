package com.cloud.security.service;

import com.cloud.security.domain.SysMenuInfo;
import com.cloud.security.domain.SysUserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * 根据用户名获取用户信息
     */
    SysUserInfo getUserInfoByUsername(String username);

    /**
     * 注册功能
     */
    SysUserInfo register(SysUserInfo sysUserInfo);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限
     */
    List<SysMenuInfo> getPermission(String username);
}
