package com.laycoding.service;

import com.laycoding.bo.UploadInfoBO;
import com.laycoding.common.utils.ResultUtil;
import com.laycoding.entity.OssConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-27
 */
public interface IOssConfigService extends IService<OssConfig> {
    /**
     *
     * @param req
     * @param file
     * @return
     */
    ResultUtil<UploadInfoBO> uploadImage(HttpServletRequest req, MultipartFile file);
}
