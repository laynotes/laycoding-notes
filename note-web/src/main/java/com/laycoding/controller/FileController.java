package com.laycoding.controller;


import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.service.IFileService;
import com.laycoding.vo.FileInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Api(tags = "文件api")
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IFileService fileService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "文件夹类型", required = true),
            @ApiImplicitParam(name = "folderId", value = "文件夹id", required = false)
    })
    @ApiOperation(value = "根据文件夹id获取文件夹下的文件")
    @RequestMapping(value = "/listFiles", method = RequestMethod.GET)
    public ResultUtil<List<FileDTO>> listFiles(Integer type, String folderId) {

        return fileService.listFiles(type, folderId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileId", value = "文件id", required = true)
    })
    @ApiOperation(value = "获取文件详情")
    @RequestMapping(value = "/getFileInfoById", method = RequestMethod.GET)
    public ResultUtil<FileInfoDTO> getFileInfoById(String fileId) {
        return fileService.getFileInfoById(fileId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileInfoVO", value = "文件详情", required = true)
    })
    @ApiOperation(value = "上传文件")

    @RequestMapping(value = "/insertFile", method = RequestMethod.POST)
    public ResultUtil<Object> insertFile(@RequestBody FileInfoVO fileInfoVO) {

        return fileService.insertFile(fileInfoVO);
    }

    @RequestMapping(value = "/deleteFile", method = RequestMethod.DELETE)
    public ResultUtil<Boolean> deleteFile(String fileId) {

        return fileService.deleteFile(fileId);
    }
}
