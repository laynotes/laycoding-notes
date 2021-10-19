package com.laycoding.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author laycoding
 * @since 2021-10-16
 */
@TableName("sys_file_info")
@ApiModel(value = "FileInfo对象", description = "")
@Data
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文件id")
    private String fileId;

    @ApiModelProperty("文件配置")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileConfig;

    @ApiModelProperty("文件标签")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileLabel;

    @ApiModelProperty("文件内容(type>0)")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileContent;

    @ApiModelProperty("文件内容(type=0)")
    private String fileSource;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

}
