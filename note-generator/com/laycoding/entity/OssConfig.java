package com.laycoding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    private String ossConfig;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getOssId() {
        return ossId;
    }

    public void setOssId(String ossId) {
        this.ossId = ossId;
    }
    public Boolean getOssType() {
        return ossType;
    }

    public void setOssType(Boolean ossType) {
        this.ossType = ossType;
    }
    public String getOssConfig() {
        return ossConfig;
    }

    public void setOssConfig(String ossConfig) {
        this.ossConfig = ossConfig;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "OssConfig{" +
            "id=" + id +
            ", userId=" + userId +
            ", ossId=" + ossId +
            ", ossType=" + ossType +
            ", ossConfig=" + ossConfig +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
