package com.laycoding.common.util;


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

        return decodedDetails.containsKey("userInfo") ? (Integer) decodedDetails.get("userInfo") : null;
    }


}
