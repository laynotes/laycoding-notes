package com.laycoding.service;

import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.AccessTokenDTO;
import com.laycoding.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
public interface IUserService extends IService<User> {
    /**
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 获取token接口
      * @param username
     * @param password
     * @return
     */
    ResultUtil<AccessTokenDTO> login(TokenEndpoint endpoint, String username, String password);

    /**
     * 注销token
     * @param endpoint
     * @param refreshToken
     * @return
     */
    ResultUtil<Object> logout(TokenEndpoint endpoint,String refreshToken);

    /**
     * 刷新token
     * @param endpoint
     * @param refreshToken
     * @return
     */
    ResultUtil<AccessTokenDTO> refreshToken(TokenEndpoint endpoint,String refreshToken);
}
