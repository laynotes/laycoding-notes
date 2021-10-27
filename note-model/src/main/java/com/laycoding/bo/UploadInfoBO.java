package com.laycoding.bo;

import lombok.Data;

/**
 * @author laycoding
 * @date 2021/10/27
 **/
@Data
public class UploadInfoBO {


    private String fileName;

    private Integer fileType;

    private String destFileName;

    private String filePath;

    private String fileUrl;

}
