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
 * @since 2021-10-15
 */
@TableName("sys_file")
@ApiModel(value = "File对象", description = "")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String fileId;

    private String folderId;

    private String fileName;

    private Boolean fileType;

    private String fileLabel;

    private String fileSource;

    private String fileContent;

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
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Boolean getFileType() {
        return fileType;
    }

    public void setFileType(Boolean fileType) {
        this.fileType = fileType;
    }
    public String getFileLabel() {
        return fileLabel;
    }

    public void setFileLabel(String fileLabel) {
        this.fileLabel = fileLabel;
    }
    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }
    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
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
        return "File{" +
            "id=" + id +
            ", userId=" + userId +
            ", fileId=" + fileId +
            ", folderId=" + folderId +
            ", fileName=" + fileName +
            ", fileType=" + fileType +
            ", fileLabel=" + fileLabel +
            ", fileSource=" + fileSource +
            ", fileContent=" + fileContent +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
