package com.laycoding.service;

import com.laycoding.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
public interface IUserService extends IService<User> {

    User getByUsername(String username);
}
