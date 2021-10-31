package com.laycoding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laycoding.common.utils.LayUtils;
import com.laycoding.common.utils.OAuthUtil;
import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FolderDTO;
import com.laycoding.entity.Folder;
import com.laycoding.mapper.FileMapper;
import com.laycoding.mapper.FolderMapper;
import com.laycoding.service.IFileService;
import com.laycoding.service.IFolderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Service
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> implements IFolderService {


    @Autowired
    OAuthUtil oAuthUtil;

    @Autowired
    FileMapper fileMapper;

    @Override
    public ResultUtil<List<FolderDTO>> listFolders() {

        Integer userId = oAuthUtil.getUserId();

        List<FolderDTO> folderList = this.baseMapper.listFolders(userId, null);

        return ResultUtil.success(folderList);
    }

    @Override
    public ResultUtil<Boolean> saveFolder(Integer folderId, String folderName) {


        Integer userId = oAuthUtil.getUserId();

        Folder folder = new Folder();

        folder.setUserId(userId);
        folder.setFolderId(LayUtils.getUuid());
        folder.setFolderName(folderName);
        folder.setParentId(folderId);

        int insert = this.baseMapper.insert(folder);
        if (insert < 1) {
            return ResultUtil.success(false);
        }
        return ResultUtil.success(true);
    }

    @Override
    public ResultUtil<Boolean> updateFolderName(String folderId, String folderName) {
        Integer userId = oAuthUtil.getUserId();

        QueryWrapper<Folder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("folder_id", folderId);
        Folder folder = new Folder();
        folder.setFolderName(folderName);
        int update = this.baseMapper.update(folder, queryWrapper);
        if (update < 1) {
            return ResultUtil.success(false);
        }
        return ResultUtil.success(true);
    }

    @Override
    public ResultUtil<Boolean> deleteFolder(String folderId) {
        Integer userId = oAuthUtil.getUserId();
        QueryWrapper<Folder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("folder_id", folderId);

        List<FileDTO> fileDTOS = fileMapper.listFiles(userId, folderId,null);
        if (!fileDTOS.isEmpty()) {
            return ResultUtil.success(false);
        }
        List<FolderDTO> folderDTOS = this.baseMapper.listFolders(userId, folderId);

        if (!folderDTOS.isEmpty() && !folderDTOS.get(0).getChildren().isEmpty()) {
            return ResultUtil.success(false);
        }

        int delete = this.baseMapper.delete(queryWrapper);
        if (delete < 1) {
            return ResultUtil.success(false);
        }
        return ResultUtil.success(true);
    }

}
