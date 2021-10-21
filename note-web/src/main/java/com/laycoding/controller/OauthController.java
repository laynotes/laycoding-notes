package com.laycoding.controller;

import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.AccessTokenDTO;
import com.laycoding.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laycoding
 */
@RestController
@Api(tags = "权限api")
@RequestMapping("/oauth")
public class OauthController {
    @Autowired
    TokenEndpoint endpoint;
    @Autowired
    IUserService userService;

    @ApiOperation(value = "获取token")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "password", name = "密码", required = true),
            @ApiImplicitParam(value = "username", name = "用户名", required = true)
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtil<AccessTokenDTO> login(@RequestParam String username, @RequestParam String password) {

        return userService.login(endpoint, username, password);
    }

    @ApiOperation(value = "注销token")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "refreshToken", name = "刷新token", required = true),
    })
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultUtil<Object> logout(@RequestParam String refreshToken) {

        return userService.logout(endpoint, refreshToken);
    }

    @ApiOperation(value = "刷新token")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "refreshToken", name = "刷新token", required = true),
    })
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResultUtil<AccessTokenDTO> refresh(@RequestParam String refreshToken) {

        return userService.refreshToken(endpoint, refreshToken);
    }

}
