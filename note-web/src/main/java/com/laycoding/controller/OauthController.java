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
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtil<AccessTokenDTO> login(@RequestParam String username, @RequestParam String password) {

        return userService.login(endpoint, username, password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultUtil<Object> logout(@RequestParam String refreshToken) {

        return userService.logout(endpoint, refreshToken);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResultUtil<AccessTokenDTO> refresh(@RequestParam String refreshToken) {

        return userService.refreshToken(endpoint, refreshToken);
    }

}
