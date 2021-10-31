package com.laycoding.mapper;

import com.laycoding.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */

public interface UserMapper extends BaseMapper<User> {

    User getByUsername(String username);

}
