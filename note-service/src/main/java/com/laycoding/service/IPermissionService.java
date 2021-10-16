package com.laycoding.service;

import com.laycoding.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
public interface IPermissionService extends IService<Permission> {


    List<Permission> queryByUserId(Integer userId);
}
