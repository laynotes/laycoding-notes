package com.laycoding.dto;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author laycoding
 */
@Data
@ApiModel(value = "文件详情")
public class FileInfoDTO implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "文件id")
    private String fileId;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "文件标签")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileLabel;

    @ApiModelProperty(value = "文件配置")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileConfig;

    @ApiModelProperty(value = "文件内容")
    private String fileSource;

    @ApiModelProperty(value = "文件内容 type>0")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileContent;
    @ApiModelProperty(value = "更新时间 type>0")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

}
