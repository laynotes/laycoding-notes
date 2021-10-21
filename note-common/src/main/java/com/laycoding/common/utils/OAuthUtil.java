package com.laycoding.common.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class OAuthUtil {


    public Integer getUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();

        LinkedHashMap<String, Object> decodedDetails = (LinkedHashMap<String, Object>) details.getDecodedDetails();

        LinkedHashMap<String, Object> userInfo = (LinkedHashMap<String, Object>) decodedDetails.get("userInfo");

        return userInfo.containsKey("id") ? (Integer) userInfo.get("id") : null;
    }


}
