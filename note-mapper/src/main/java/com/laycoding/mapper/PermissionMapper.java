package com.laycoding.mapper;

import com.laycoding.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */

public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 根据用户id获取权限
     * @param userId
     * @return
     */
    List<Permission> queryByUserId(Integer userId);
}
