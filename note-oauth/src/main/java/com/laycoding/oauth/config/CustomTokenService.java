package com.laycoding.oauth.config;

import com.laycoding.common.enums.ErrorCodeEnum;
import com.laycoding.common.enums.RedisKeyEnum;
import com.laycoding.common.exceptions.BaseException;
import com.laycoding.service.impl.RedisServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;

/**
 * @author laycoding
 */
@Log4j2
public class CustomTokenService extends DefaultTokenServices {

    private RedisServiceImpl redisService;

    public CustomTokenService(RedisServiceImpl redisService) {
        this.redisService = redisService;
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        return super.readAccessToken(accessToken);
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessTokenValue) throws InvalidTokenException {
        OAuth2Authentication oAuth2Authentication = super.loadAuthentication(accessTokenValue);
        LinkedHashMap<String, Object> details = (LinkedHashMap) oAuth2Authentication.getDetails();
        LinkedHashMap<String, Object> userInfo = (LinkedHashMap<String, Object>) details.get("userInfo");
        Integer userId = (Integer) userInfo.get("id");
        String token = redisService.get(RedisKeyEnum.USER_TOKEN.getKey() + userId);
        if (StringUtils.isEmpty(token)) {
            throw new InvalidTokenException("Access token expired: " + accessTokenValue);
        }
        if (!accessTokenValue.equals(token)) {
            throw new InvalidTokenException("Access token expired ");
        }
        return oAuth2Authentication;
    }

    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
        OAuth2AccessToken token = super.createAccessToken(authentication);

        return token;
    }

    @Override
    public OAuth2AccessToken refreshAccessToken(String refreshTokenValue, TokenRequest tokenRequest)
            throws AuthenticationException {

        OAuth2AccessToken token = super.refreshAccessToken(refreshTokenValue, tokenRequest);
        return token;
    }
}

