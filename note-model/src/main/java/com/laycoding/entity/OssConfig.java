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
 * 
 * </p>
 *
 * @author laycoding
 * @since 2021-10-27
 */
@TableName("sys_oss_config")
@ApiModel(value = "OssConfig对象", description = "")
@Data
public class OssConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("存储唯一标识")
    private String ossId;

    @ApiModelProperty("存储类型")
    private Boolean ossType;

    @ApiModelProperty("配置详情")
    private Object ossConfig;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

}
