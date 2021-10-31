package com.laycoding.mapper;

import com.laycoding.dto.FolderDTO;
import com.laycoding.entity.Folder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
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

public interface FolderMapper extends BaseMapper<Folder> {

    /**
     * 获取归档
     * @param uid
     * @param folderId
     * @return
     */
    List<FolderDTO> listFolders(Integer uid,String folderId);


}
