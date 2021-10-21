package com.laycoding.controller;

import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.AccessTokenDTO;
import com.laycoding.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "权限接口")
@RequestMapping("/oauth")
public class OauthController {
    @Autowired
    TokenEndpoint endpoint;
    @Autowired
    IUserService userService;

    @ApiOperation(value = "获取token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtil<AccessTokenDTO> login(@RequestParam String username, @RequestParam String password) {

        return userService.login(endpoint, username, password);
    }
    @ApiOperation(value = "注销token")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultUtil<Object> logout(@RequestParam String refreshToken) {

        return userService.logout(endpoint, refreshToken);
    }
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResultUtil<AccessTokenDTO> refresh(@RequestParam String refreshToken) {

        return userService.refreshToken(endpoint, refreshToken);
    }

}
