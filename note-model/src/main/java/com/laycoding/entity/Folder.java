package com.laycoding.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_folder")
public class Folder {
    private Integer id;

    private Integer userId;

    private String folderId;

    private String folderName;

    private Integer parentId;

    private Integer isEditor;

    private Date createTime;

    private Date modifyTime;
}
