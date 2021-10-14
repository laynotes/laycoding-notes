package com.laycoding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laycoding.entity.Folder;

import java.util.List;


public interface FolderService extends IService<Folder> {

     List<Folder> getAllFolder();
}
