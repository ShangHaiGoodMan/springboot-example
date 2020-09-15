package com.cloud.security.service.impl;

import com.cloud.security.dao.SysUserInfoRepository;
import com.cloud.security.domain.SysMenuInfo;
import com.cloud.security.domain.SysUserInfo;
import com.cloud.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private SysUserInfoRepository sysUserInfoRepository;

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     */
    @Override
    public SysUserInfo getUserInfoByUsername(String username) {
        SysUserInfo sysUserInfo =  sysUserInfoRepository.findByUsername(username);
        return sysUserInfo;
    }

    /**
     * 注册功能
     *
     * @param sysUserInfo
     */
    @Override
    public SysUserInfo register(SysUserInfo sysUserInfo) {
        SysUserInfo existsUser =  sysUserInfoRepository.findByUsername(sysUserInfo.getUsername());
        if(null != existsUser){
            return null;
        }
        String encodePassword = passwordEncoder.encode(sysUserInfo.getPassword());
        sysUserInfo.setPassword(encodePassword);
        sysUserInfoRepository.save(sysUserInfo);
        sysUserInfo.setPassword(null);
        return sysUserInfo;
    }

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    @Override
    public String login(String username, String password) {
        return null;
    }

    /**
     * 获取用户所有权限
     *
     * @param username
     */
    @Override
    public List<SysMenuInfo> getPermission(String username) {
        return null;
    }
}
