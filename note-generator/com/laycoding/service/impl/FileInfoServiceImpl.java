package com.laycoding.service.impl;

import com.laycoding.entity.FileInfo;
import com.laycoding.mapper.FileInfoMapper;
import com.laycoding.service.IFileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-16
 */
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements IFileInfoService {

}
