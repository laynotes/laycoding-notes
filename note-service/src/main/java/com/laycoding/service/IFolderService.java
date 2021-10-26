package com.laycoding.service;

import com.laycoding.common.utils.ResultUtil;
import com.laycoding.dto.FolderDTO;
import com.laycoding.entity.Folder;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 归档服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
public interface IFolderService extends IService<Folder> {
    /**
     * 获取归档列表
     * @return
     */
    ResultUtil<List<FolderDTO>> listFolders();

    /**
     * 保存归档(文件夹)
     *
     * @param folderId 归档主键id
     * @param folderName 归档名称
     * @return ResultUtil<Boolean>
     */
    ResultUtil<Boolean> saveFolder(Integer folderId, String folderName);

    /**
     * 更新归档名称
     * @param folderId
     * @param folderName
     * @return
     */
    ResultUtil<Boolean> updateFolderName(String folderId,String folderName);

    /**
     * 删除归档
     * @param folderId
     * @return
     */
    ResultUtil<Boolean> deleteFolder(String folderId);

}
