package com.laycoding.service.impl;

import com.laycoding.dto.UserDetailDTO;
import com.laycoding.dto.UserInfoDTO;
import com.laycoding.entity.Permission;
import com.laycoding.entity.User;
import com.laycoding.mapper.PermissionMapper;
import com.laycoding.mapper.UserMapper;
import com.laycoding.service.IPermissionService;
import com.laycoding.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private PermissionMapper permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (user == null) {
            return null;
        }
        UserInfoDTO userInfo = new UserInfoDTO();
        BeanUtils.copyProperties(user, userInfo);
        List<Permission> permissionList = permissionService.queryByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (permissionList != null && !permissionList.isEmpty()) {
            permissionList.forEach(permission -> {
                if (permission != null && !StringUtils.isEmpty(permission.getEnname())) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission.getEnname());
                    grantedAuthorities.add(authority);
                }
            });
        }
        return new UserDetailDTO(userInfo, user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}

