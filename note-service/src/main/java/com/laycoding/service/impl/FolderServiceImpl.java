package com.laycoding.service.impl;

import com.laycoding.common.util.OAuthUtil;
import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FolderDTO;
import com.laycoding.entity.Folder;
import com.laycoding.mapper.FolderMapper;
import com.laycoding.service.IFolderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    
    
    @Override
    public ResultUtil<List<FolderDTO>> listFolders() {

        Integer userId = oAuthUtil.getUserId();

        List<FolderDTO> folderList = this.baseMapper.listFolders(userId);

        List<FolderDTO> parentList = folderList.stream().filter(obj -> {
            return obj.getParentId() == 0;
        }).map(obj -> {
            obj.setChildren(new ArrayList<>());
            return makeTree(folderList, obj);
        }).collect(Collectors.toList());

        return ResultUtil.success(parentList);
    }

    /**
     * 构建文件夹树
     * @param list
     * @param folderDTO
     * @return
     */
    public FolderDTO makeTree(List<FolderDTO> list, FolderDTO folderDTO) {
        List<FolderDTO> children = folderDTO.getChildren();
        list.stream().filter(obj -> {
            return obj.getParentId() > 0;
        }).forEach(obj -> {
            if (folderDTO.getId().equals(obj.getParentId())) {
                children.add(obj);
            }
        });
        return folderDTO;
    }
}
