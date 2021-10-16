package com.laycoding.service;

import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FolderDTO;
import com.laycoding.entity.Folder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
public interface IFolderService extends IService<Folder> {

    ResultUtil<List<FolderDTO>> listFolders();
}
