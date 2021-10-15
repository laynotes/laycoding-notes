package com.laycoding.service.impl;

import com.laycoding.common.util.Result;
import com.laycoding.entity.File;
import com.laycoding.mapper.FileMapper;
import com.laycoding.service.IFileService;
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
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Override
    public Result<List<File>> listFiles() {
        List<File> files = this.baseMapper.selectList(null);
        return Result.success(files);
    }
}
