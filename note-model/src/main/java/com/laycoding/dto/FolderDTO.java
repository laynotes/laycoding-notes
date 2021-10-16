package com.laycoding.dto;

import com.laycoding.entity.Folder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author laycoding
 */
@Data
public class FolderDTO implements Serializable {

    private Integer id;

    private String folderId;

    private Integer parentId;

    private String folderName;

    private Integer isEditor;

    private List<FolderDTO> children;
}
