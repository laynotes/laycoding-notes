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
 * 权限表
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@TableName("sys_permission")
@ApiModel(value = "Permission对象", description = "权限表")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("父权限")
    private Long parentId;

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("权限英文名称")
    private String enname;

    @ApiModelProperty("授权路径")
    private String url;

    @ApiModelProperty("备注")
    private String description;

    private LocalDateTime created;

    private LocalDateTime updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Permission{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", name=" + name +
            ", enname=" + enname +
            ", url=" + url +
            ", description=" + description +
            ", created=" + created +
            ", updated=" + updated +
        "}";
    }
}
