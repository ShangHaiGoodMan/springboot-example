package com.cloud.security.service.impl;

import com.cloud.security.auth.LoginUser;
import com.cloud.security.dao.SysMenuInfoRepository;
import com.cloud.security.dao.SysUserRoleInfoRepository;
import com.cloud.security.domain.SysMenuInfo;
import com.cloud.security.domain.SysUserInfo;
import com.cloud.security.domain.SysUserRoleInfo;
import com.cloud.security.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Resource
    private SysUserRoleInfoRepository sysUserRoleInfoRepository;

    @Resource
    private SysMenuInfoRepository sysMenuInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser loginUser = new LoginUser();
        SysUserInfo sysUserInfo = userInfoService.getUserInfoByUsername(username);
        BeanUtils.copyProperties(sysUserInfo, loginUser);
        if (sysUserInfo == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        Set<SysUserRoleInfo> sysUserRoleInfos = sysUserRoleInfoRepository.findRolesByUserId(loginUser.getId());
        Set<String> roleIds = sysUserRoleInfos.stream().map(e->e.getRoleId()).collect(Collectors.toSet());
        Set<SysMenuInfo> sysMenuInfos = sysMenuInfoRepository.findByRoleIds(roleIds);
        Set<String> permissions = sysMenuInfos.stream().map(e->e.getPermission()).collect(Collectors.toSet());
        loginUser.setRoles(roleIds);
        loginUser.setPermissions(permissions);
        return loginUser;
    }

}