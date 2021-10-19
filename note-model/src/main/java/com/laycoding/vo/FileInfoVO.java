package com.laycoding.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

@Data
public class FileInfoVO implements Serializable {

    private String folderId;

    private String fileId;

    private String fileName;

    private Integer fileType;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileLabel;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileConfig;

    private String fileSource;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileContent;

}
