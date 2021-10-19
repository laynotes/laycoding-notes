package com.laycoding.dto;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author laycoding
 */
@Data
public class FileInfoDTO implements Serializable {

    private Integer id;

    private String fileId;

    private String fileName;

    private String fileType;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileLabel;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileConfig;

    private String fileSource;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object fileContent;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

}
