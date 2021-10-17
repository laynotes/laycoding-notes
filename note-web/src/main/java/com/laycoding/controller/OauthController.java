package com.laycoding.controller;

import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.AccessTokenDTO;
import com.laycoding.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author laycoding
 */
@RestController
@RequestMapping("/oauth")
public class OauthController {
    @Autowired
    TokenEndpoint endpoint;
    @Autowired
    IUserService userService;

    @RequestMapping("/login")
    public ResultUtil<AccessTokenDTO> login(@RequestParam String username, @RequestParam String password) {

        return userService.login(endpoint, username, password);
    }

    @RequestMapping("/logout")
    public ResultUtil<AccessTokenDTO> logout( @RequestParam String refreshToken) {

        return userService.logout(endpoint,refreshToken);
    }


}
