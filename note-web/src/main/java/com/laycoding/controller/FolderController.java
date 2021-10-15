package com.laycoding.controller;


import com.laycoding.common.util.Result;
import com.laycoding.entity.Folder;
import com.laycoding.service.IFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private IFolderService folderService;

    @RequestMapping("/listFolder")
    @PreAuthorize("hasAnyAuthority('SystemUserInsert')")
    public Result<List<Folder>> listFolder(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return folderService.listFolder();
    }
}
