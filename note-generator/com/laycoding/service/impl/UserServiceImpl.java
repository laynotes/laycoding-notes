package com.laycoding.service.impl;

import com.laycoding.entity.User;
import com.laycoding.mapper.UserMapper;
import com.laycoding.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
