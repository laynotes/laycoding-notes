package com.laycoding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laycoding.common.enums.ErrorCodeEnum;
import com.laycoding.common.enums.FolderReqTypeEnum;
import com.laycoding.common.utils.OAuthUtil;
import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.entity.File;
import com.laycoding.entity.FileInfo;
import com.laycoding.entity.Folder;
import com.laycoding.mapper.FileInfoMapper;
import com.laycoding.mapper.FileMapper;
import com.laycoding.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laycoding.service.IFolderService;
import com.laycoding.vo.FileInfoVO;
import com.laycoding.vo.FileUpdateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Autowired
    IFolderService iFolderService;

    @Override
    public ResultUtil<List<FileDTO>> listFiles(Integer type, String folderId,String val) {
        Integer userId = oAuthUtil.getUserId();
        List<FileDTO> files = null;
        if (FolderReqTypeEnum.RECENT_FILE.getType().equals(type)) {
            files = this.baseMapper.listFiles(userId, null,val);
        }
        if (FolderReqTypeEnum.CREATE_FILE.getType().equals(type)) {
            files = this.baseMapper.listFiles(userId, folderId,val);
        }
        return ResultUtil.success(files);
    }

    @Override
    public ResultUtil<FileInfoDTO> getFileInfoById(String fileId) {
        Integer userId = oAuthUtil.getUserId();
        FileInfoDTO fileInfo = this.baseMapper.getFileInfoById(userId, fileId);
        return ResultUtil.success(fileInfo);
    }

    @Override
    @Transactional
    public ResultUtil<Object> insertFile(FileInfoVO fileInfoVO) {
        QueryWrapper<File> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("file_id", fileInfoVO.getFileId());
        File fileOne = this.baseMapper.selectOne(queryWrapper);
        Integer userId = oAuthUtil.getUserId();
        FileInfo fileInfo = new FileInfo();
        BeanUtils.copyProperties(fileInfoVO, fileInfo);
        if (fileOne != null && fileOne.getUserId().equals(userId)) {
            QueryWrapper<FileInfo> queryInfo = new QueryWrapper<>();
            queryInfo.eq("file_id", fileInfoVO.getFileId());
            fileInfoMapper.update(fileInfo, queryInfo);
            return ResultUtil.success(true);
        } else if (fileOne != null && !fileOne.getUserId().equals(userId)) {
            return ResultUtil.otherError(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }
        File file = new File();
        file.setUserId(userId);
        BeanUtils.copyProperties(fileInfoVO, file);
        int insert = this.baseMapper.insert(file);
        if (insert > 0) {
            Integer integer = fileInfoMapper.insert(fileInfo);
        }
        return ResultUtil.success(true);
    }

    @Override
    public ResultUtil<Boolean> deleteFile(String fileId) {
        QueryWrapper<File> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("file_id", fileId);
        int delete = this.baseMapper.delete(queryWrapper);
        if (delete < 1) {
            return ResultUtil.success(false);
        }
        return ResultUtil.success(true);
    }

    @Override
    public ResultUtil<Boolean> updateFileName(FileUpdateVO fileUpdateVO) {
        Integer userId = oAuthUtil.getUserId();
        if (fileUpdateVO.getType().equals(1)) {
            QueryWrapper<File> fileQueryWrapper = new QueryWrapper<>();
            fileQueryWrapper.eq("file_id", fileUpdateVO.getId());
            fileQueryWrapper.eq("user_id", userId);
            File file = new File();
            file.setFileName(fileUpdateVO.getName());
            int update = this.baseMapper.update(file, fileQueryWrapper);
            if (update > 0) {
                return ResultUtil.success(true);
            }
            return ResultUtil.success(false);
        }
        return iFolderService.updateFolderName(fileUpdateVO.getId(), fileUpdateVO.getName());
    }

    @Override
    public ResultUtil<IPage<FileDTO>> listPages(String folderId, String val, Integer pageNum,Integer pageSize) {

        Integer userId = oAuthUtil.getUserId();
        IPage<FileDTO> pages = this.baseMapper.listPages(new Page<>(pageNum, pageSize), userId, folderId, val);
        return ResultUtil.success(pages);
    }
}
