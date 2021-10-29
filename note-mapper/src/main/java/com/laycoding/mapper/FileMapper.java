package com.laycoding.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.entity.File;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laycoding.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {
    /**
     * 获取文件列表
     *
     * @param uid
     * @param folderId
     * @return
     */
    List<FileDTO> listFiles(Integer uid, String folderId);


    /**
     * 获取文件详情
     *
     * @param uid    用户id
     * @param fileId 文件id
     * @return 文件详情
     */
    FileInfoDTO getFileInfoById(Integer uid, String fileId);

    /**
     * 添加文件详情
     *
     * @param fileInfo
     * @return
     */
    Integer insertFileInfo(FileInfo fileInfo);

    /**
     * 分页获取
     * @param page
     * @param userId
     * @param folderId
     * @param val
     * @return
     */
    IPage<FileDTO> listPages(Page<FileDTO> page, Integer userId, String folderId, String val);

}
