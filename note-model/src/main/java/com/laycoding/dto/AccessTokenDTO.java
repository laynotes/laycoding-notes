package com.laycoding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "AccessTokenDTO",description = "token相关信息")
public class AccessTokenDTO implements Serializable {

    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("refreshToken")
    private String refreshToken;
    @ApiModelProperty("token")
    private String token;
}
