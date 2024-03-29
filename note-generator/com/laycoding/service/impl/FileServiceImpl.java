package com.laycoding.service.impl;

import com.laycoding.entity.File;
import com.laycoding.mapper.FileMapper;
import com.laycoding.service.IFileService;
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
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
