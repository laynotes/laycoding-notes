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
@TableName("sys_folder")
@ApiModel(value = "Folder对象", description = "")
public class Folder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("文件夹id")
    private String folderId;

    @ApiModelProperty("父id")
    private Integer parentId;

    @ApiModelProperty("文件夹名称")
    private String folderName;

    @ApiModelProperty("是否可以编辑")
    private Integer isEditor;

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
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
    public Integer getIsEditor() {
        return isEditor;
    }

    public void setIsEditor(Integer isEditor) {
        this.isEditor = isEditor;
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
        return "Folder{" +
            "id=" + id +
            ", userId=" + userId +
            ", folderId=" + folderId +
            ", parentId=" + parentId +
            ", folderName=" + folderName +
            ", isEditor=" + isEditor +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
