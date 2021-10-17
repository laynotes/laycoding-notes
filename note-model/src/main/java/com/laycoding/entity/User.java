package com.laycoding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author laycoding
 * @since 2021-10-16
 */
@TableName("sys_user")
@ApiModel(value = "User对象", description = "用户表")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String name;

    @ApiModelProperty("密码，加密存储")
    private String password;

    @ApiModelProperty("注册手机号")
    private String phone;

    @ApiModelProperty("注册邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("禁止登入")
    private Integer isDelete;

    @ApiModelProperty("创建时间 ")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime modifyTime;

}
