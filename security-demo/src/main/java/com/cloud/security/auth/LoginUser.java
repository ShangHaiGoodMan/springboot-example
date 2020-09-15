package com.cloud.security.auth;

import com.cloud.security.domain.SysUserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * 用户实体绑定spring security
 */
@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUser extends SysUserInfo implements UserDetails {

    private Set<String> roles;

    private Set<String> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        Collection<GrantedAuthority> synchronizedCollection = Collections.synchronizedCollection(collection);
        if (!CollectionUtils.isEmpty(roles)) {
            roles.parallelStream().forEach(role -> {
                if (role.startsWith("ROLE_")) {
                    synchronizedCollection.add(new SimpleGrantedAuthority(role));
                } else {
                    synchronizedCollection.add(new SimpleGrantedAuthority("ROLE_" + role));
                }
            });
        }

        if (!CollectionUtils.isEmpty(permissions)) {
            permissions.parallelStream().filter(per-> StringUtils.isNotEmpty(per)).forEach(per -> {
                synchronizedCollection.add(new SimpleGrantedAuthority(per));
            });
        }
        return collection;
    }

    @JsonIgnore
    public Collection<? extends GrantedAuthority> putAll(Collection<GrantedAuthority> collections) {
        Collection<GrantedAuthority> collection = new HashSet<>();
        collection.addAll(collections);
        return collection;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
