package com.laycoding.service.impl;

import com.laycoding.common.util.Result;
import com.laycoding.entity.Folder;
import com.laycoding.mapper.FolderMapper;
import com.laycoding.service.IFolderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Service
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> implements IFolderService {

    @Override
    public Result<List<Folder>> listFolder() {
        return Result.success(this.baseMapper.selectList(null));
    }
}
