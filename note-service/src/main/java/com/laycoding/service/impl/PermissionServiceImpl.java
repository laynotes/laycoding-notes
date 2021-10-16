package com.laycoding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laycoding.entity.Permission;
import com.laycoding.mapper.PermissionMapper;
import com.laycoding.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public List<Permission> queryByUserId(Integer userId) {
        return this.baseMapper.queryByUserId(userId);
    }
}
