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
 * @since 2021-10-16
 */
@TableName("sys_file")
@ApiModel(value = "File对象", description = "")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("文件唯一标识")
    private String fileId;

    @ApiModelProperty("所属文件夹")
    private String folderId;

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("文件类型")
    private Integer fileType;

    @ApiModelProperty("是否公开")
    private Integer isShare;

    @ApiModelProperty("是否删除")
    private Integer isDelete;

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
    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
            ", isShare=" + isShare +
            ", isDelete=" + isDelete +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
