package com.laycoding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laycoding.common.util.OAuthUtil;
import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.AccessTokenDTO;
import com.laycoding.dto.UserInfoDTO;
import com.laycoding.entity.User;
import com.laycoding.mapper.UserMapper;
import com.laycoding.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    RedisServiceImpl redisService;

    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // o = redisTemplate.opsForValue().get("getuser:" + username);

        return this.baseMapper.selectOne(wrapper.eq("username", username));
    }

    @Override
    public ResultUtil<AccessTokenDTO> login(TokenEndpoint endpoint, String username, String password) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
        parameters.put("grant_type", "password");
        parameters.put("client_id", "admin-app");
        parameters.put("client_secret", "123456");

        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("admin-app", "null", new ArrayList<>());
        AppAuthenticationServiceImpl appAuthenticationToken = new AppAuthenticationServiceImpl(user, null);
        appAuthenticationToken.setAuthenticated(true);

        ResponseEntity<OAuth2AccessToken> oAuth2AccessTokenResponseEntity = new ResponseEntity<OAuth2AccessToken>(HttpStatus.OK);

        try {
            oAuth2AccessTokenResponseEntity = endpoint.postAccessToken(appAuthenticationToken, parameters);
        } catch (HttpRequestMethodNotSupportedException e) {
            e.printStackTrace();
        }
        OAuth2AccessToken body = oAuth2AccessTokenResponseEntity.getBody();
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setToken(body.getValue());
        accessTokenDTO.setRefreshToken(body.getRefreshToken().getValue());
        Map<String, Object> additionalInformation = body.getAdditionalInformation();
        UserInfoDTO userInfo = (UserInfoDTO) additionalInformation.get("userInfo");

        BeanUtils.copyProperties(userInfo, accessTokenDTO);

        redisService.setEx("user:"+userInfo.getId()+":token",accessTokenDTO.getToken(),100, TimeUnit.SECONDS);

        return ResultUtil.success(accessTokenDTO);
    }

    @Override
    public ResultUtil<AccessTokenDTO> logout(TokenEndpoint endpoint, String refreshToken) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("refresh_token", refreshToken);
        parameters.put("client_id", "admin-app");
        parameters.put("client_secret", "123456");
        parameters.put("grant_type", "refresh_token");
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("admin-app", "null", new ArrayList<>());
        AppAuthenticationServiceImpl appAuthenticationToken = new AppAuthenticationServiceImpl(user, null);
        appAuthenticationToken.setAuthenticated(true);

        ResponseEntity<OAuth2AccessToken> oAuth2AccessTokenResponseEntity = new ResponseEntity<OAuth2AccessToken>(HttpStatus.OK);

        try {
            oAuth2AccessTokenResponseEntity = endpoint.postAccessToken(appAuthenticationToken, parameters);
        } catch (HttpRequestMethodNotSupportedException e) {
            e.printStackTrace();
        }
        OAuth2AccessToken body = oAuth2AccessTokenResponseEntity.getBody();
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setToken(body.getValue());
        accessTokenDTO.setRefreshToken(body.getRefreshToken().getValue());
        Map<String, Object> additionalInformation = body.getAdditionalInformation();
        UserInfoDTO userInfo = (UserInfoDTO) additionalInformation.get("userInfo");

        redisService.delete("user:"+userInfo.getId()+":token");
        BeanUtils.copyProperties(userInfo, accessTokenDTO);
        return ResultUtil.success(accessTokenDTO);
    }
}
