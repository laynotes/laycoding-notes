package com.laycoding.entity;

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
 * @since 2021-10-16
 */
@TableName("sys_file_info")
@ApiModel(value = "FileInfo对象", description = "")
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty("文件id")
    private String fileId;

    @ApiModelProperty("文件配置")
    private String fileConfig;

    @ApiModelProperty("文件标签")
    private String fileLabel;

    @ApiModelProperty("文件内容(type>0)")
    private String fileContent;

    @ApiModelProperty("文件内容(type=0)")
    private String fileSource;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    public String getFileConfig() {
        return fileConfig;
    }

    public void setFileConfig(String fileConfig) {
        this.fileConfig = fileConfig;
    }
    public String getFileLabel() {
        return fileLabel;
    }

    public void setFileLabel(String fileLabel) {
        this.fileLabel = fileLabel;
    }
    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
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
        return "FileInfo{" +
            "id=" + id +
            ", fileId=" + fileId +
            ", fileConfig=" + fileConfig +
            ", fileLabel=" + fileLabel +
            ", fileContent=" + fileContent +
            ", fileSource=" + fileSource +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
