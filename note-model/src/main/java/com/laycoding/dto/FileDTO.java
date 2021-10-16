package com.laycoding.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author laycoding
 */
@Data
public class FileDTO implements Serializable {


    private Integer id;

    private String fileId;

    private Integer fileType;

    private String fileName;

    private String folderName;

    private Date createTime;

    private Date updateTime;

}
