package com.laycoding.service.impl;

import com.laycoding.common.enums.FolderReqTypeEnum;
import com.laycoding.common.util.OAuthUtil;
import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.entity.File;
import com.laycoding.mapper.FileMapper;
import com.laycoding.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Autowired
    OAuthUtil oAuthUtil;

    @Override
    public ResultUtil<List<FileDTO>> listFiles(Integer type,String folderId) {
        Integer userId = oAuthUtil.getUserId();
        List<FileDTO> files = null;
        if (FolderReqTypeEnum.RECENT_FILE.getType().equals(type)){
            files = this.baseMapper.listFiles(userId, null);
        }
        if (FolderReqTypeEnum.CREATE_FILE.getType().equals(type)){
            files = this.baseMapper.listFiles(userId, folderId);
        }
        return ResultUtil.success(files);
    }

    @Override
    public ResultUtil<FileInfoDTO> getFileInfoById(String fileId) {

        Integer userId = oAuthUtil.getUserId();

        FileInfoDTO fileInfo = this.baseMapper.getFileInfoById(userId, fileId);
        return ResultUtil.success(fileInfo);
    }
}
