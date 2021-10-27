package com.laycoding.controller;


import com.laycoding.bo.UploadInfoBO;
import com.laycoding.common.utils.ResultUtil;
import com.laycoding.service.IOssConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author laycoding
 * @since 2021-10-27
 */
@RestController
@RequestMapping("/oss")
public class OssConfigController {


    @Autowired
    private IOssConfigService iOssConfigService;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public ResultUtil<UploadInfoBO> uploadImage(HttpServletRequest req, @RequestParam("file") MultipartFile file) {//1. 接受上传的文件  @RequestParam("file") MultipartFile file


        return iOssConfigService.uploadImage(req, file);
    }
}
