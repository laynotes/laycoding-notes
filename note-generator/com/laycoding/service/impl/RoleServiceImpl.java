package com.laycoding.service.impl;

import com.laycoding.entity.Role;
import com.laycoding.mapper.RoleMapper;
import com.laycoding.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
