package com.laycoding.mapper;

import com.laycoding.dto.FolderDTO;
import com.laycoding.entity.Folder;
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
public interface FolderMapper extends BaseMapper<Folder> {

    /**
     * 根据用户id获取文件夹列表
     * @param uid
     * @return
     */
    List<FolderDTO> listFolders(Integer uid);
}
