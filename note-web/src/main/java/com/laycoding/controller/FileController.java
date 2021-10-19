package com.laycoding.controller;


import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.entity.File;
import com.laycoding.service.IFileService;
import com.laycoding.vo.FileInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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
    public ResultUtil<List<FileDTO>> listFiles(Integer type,String folderId){

        return fileService.listFiles(type,folderId);
    }

    @RequestMapping(value = "/getFileInfoById",method = RequestMethod.GET)
    public ResultUtil<FileInfoDTO> getFileInfoById(String fileId){
        return fileService.getFileInfoById(fileId);
    }

    @RequestMapping(value = "/insertFile",method = RequestMethod.POST)
    public ResultUtil<Object> insertFile(@RequestBody FileInfoVO fileInfoVO){

        ResultUtil<Object> objectResultUtil = fileService.insertFile(fileInfoVO);

        return objectResultUtil;
    }
}
