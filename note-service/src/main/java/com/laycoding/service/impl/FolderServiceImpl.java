package com.laycoding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laycoding.entity.Folder;
import com.laycoding.mapper.FolderMapper;
import com.laycoding.service.FolderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> implements FolderService {
    @Override
    public List<Folder> getAllFolder() {
        List<Folder> sysFolders = this.baseMapper.selectList(null);
        return sysFolders;
    }
}
