package com.laycoding.controller;


import com.laycoding.common.util.Result;
import com.laycoding.entity.File;
import com.laycoding.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IFileService fileService;

    @RequestMapping("/listFiles")
    public Result<List<File>> getAll(){

        return fileService.listFiles();
    }
}
