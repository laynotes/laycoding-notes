package com.laycoding.mapper;

import com.laycoding.dto.FileDTO;
import com.laycoding.dto.FileInfoDTO;
import com.laycoding.entity.File;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laycoding
 * @since 2021-10-15
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {
   /**
    * 获取文件列表
    * @param uid
    * @param folderId
    * @return
    */
   List<FileDTO> listFiles(Integer uid , String folderId);


   /**
    * 获取文件详情
    * @param uid 用户id
    * @param fileId 文件id
    * @return 文件详情
    */
   FileInfoDTO getFileInfoById(Integer uid,String fileId);

}
