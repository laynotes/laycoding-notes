package com.laycoding.controller;


import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.FolderDTO;
import com.laycoding.service.IFolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
@Api(tags = "归档api")
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private IFolderService folderService;

    @ApiOperation(value = "获取归档")
    @RequestMapping(value = "/listFolders", method = RequestMethod.GET)
    public ResultUtil<List<FolderDTO>> listFolder() {
        return folderService.listFolders();
    }

    @ApiOperation(value = "新增归档")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "folderId", name = "父归档id"),
            @ApiImplicitParam(value = "folderName", name = "归档名称",required = true)
    }
    )
    @RequestMapping(value = "/saveFolder",method = RequestMethod.POST)
    public ResultUtil<Boolean> saveFolder(Integer folderId, String folderName) {
        return folderService.saveFolder(folderId, folderName);
    }
}
