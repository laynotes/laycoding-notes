package com.laycoding.service;

import com.laycoding.common.util.ResultUtil;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import com.laycoding.vo.FileInfoVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
public interface IFileService extends IService<File> {
    /**
     * 获取文件列表
     *
     * @param type
     * @return
     */
    ResultUtil<List<FileDTO>> listFiles(Integer type, String folderId);

    /**
     * 获取文件详情
     *
     * @param fileId
     * @return
     */
    ResultUtil<FileInfoDTO> getFileInfoById(String fileId);

    /**
     * 新增文件
     *
     * @param fileInfoVO 文件详情
     * @return ResultUtil<Object>
     * @author laycoding
     **/
    ResultUtil<Object> insertFile(FileInfoVO fileInfoVO);
}
