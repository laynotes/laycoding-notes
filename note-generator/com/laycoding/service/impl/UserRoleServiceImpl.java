package com.laycoding.service.impl;

import com.laycoding.entity.UserRole;
import com.laycoding.mapper.UserRoleMapper;
import com.laycoding.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-16
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
