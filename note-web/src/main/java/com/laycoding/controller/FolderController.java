package com.laycoding.controller;


import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FolderDTO;
import com.laycoding.service.IFolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@RestController
@Api(tags = "文件夹")
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private IFolderService folderService;
    @ApiOperation(value = "获取当前用户所有文件夹")
    @RequestMapping(value = "/listFolders", method = RequestMethod.GET)
    public ResultUtil<List<FolderDTO>> listFolder() {
        return folderService.listFolders();
    }
}
