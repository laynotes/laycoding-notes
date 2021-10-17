package com.laycoding.dto;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;


public class UserDetailDTO extends User {

    private UserInfoDTO userInfo;


    public UserDetailDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

    }
    public UserDetailDTO(UserInfoDTO userInfo,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userInfo=userInfo;
    }
    public UserDetailDTO(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
    }
}
