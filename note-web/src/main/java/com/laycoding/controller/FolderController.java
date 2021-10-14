package com.laycoding.controller;

import com.laycoding.common.util.Result;
import com.laycoding.entity.Folder;
import com.laycoding.service.FolderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文件夹模块")
@RestController
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private FolderService sysFolderService;

    @ApiOperation(value = "获取所有文件")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Result<List<Folder>> getAll() {

        return Result.success(sysFolderService.getAllFolder());
    }
}
