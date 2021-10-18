package com.laycoding.oauth.config;

import com.laycoding.dto.UserDetailDTO;
import com.laycoding.dto.UserInfoDTO;
import com.laycoding.entity.User;
import com.laycoding.service.IUserService;
import com.laycoding.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtTokenEnhancer extends JwtAccessTokenConverter {

    @Autowired
    IUserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();
        if (!(authentication.getPrincipal() instanceof String)) {
            UserDetailDTO securityUser = (UserDetailDTO) authentication.getPrincipal();
            info.put("userInfo", securityUser.getUserInfo());
        } else {
            User user = userService.getByUsername((String) authentication.getPrincipal());
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            BeanUtils.copyProperties(user,userInfoDTO);
            info.put("userInfo",userInfoDTO);
        }
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

    @Override
    public Map<String, Object> decode(String token) {
        Map<String, Object> decode = super.decode(token);

        UserDetailDTO userInfo = (UserDetailDTO) decode.get("userInfo");
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        //注意这里获取到的权限 虽然数据库存的权限是 "sys:menu:add"  但是这里就变成了"{authority=sys:menu:add}" 所以使用@PreAuthorize("hasAuthority('{authority=sys:menu:add}')")
        List<LinkedHashMap<String, String>> authorities = (List<LinkedHashMap<String, String>>) decode.get("authorities");
        for (LinkedHashMap<String, String> authority : authorities) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getOrDefault("authority", "N/A"));
            grantedAuthorityList.add(grantedAuthority);
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userInfo, null, grantedAuthorityList);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return decode;
    }
}
