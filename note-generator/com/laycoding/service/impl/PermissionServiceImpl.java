package com.laycoding.service.impl;

import com.laycoding.entity.Permission;
import com.laycoding.mapper.PermissionMapper;
import com.laycoding.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-16
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
