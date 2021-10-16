package com.laycoding.controller;


import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FolderDTO;
import com.laycoding.service.IFolderService;
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
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private IFolderService folderService;

    @RequestMapping(value = "/listFolders", method = RequestMethod.GET)
    public ResultUtil<List<FolderDTO>> listFolder() {
        return folderService.listFolders();
    }
}
