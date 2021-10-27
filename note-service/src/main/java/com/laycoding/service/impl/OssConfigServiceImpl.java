package com.laycoding.service.impl;

import com.laycoding.bo.UploadInfoBO;
import com.laycoding.common.utils.LayUtils;
import com.laycoding.common.utils.OssUtils;
import com.laycoding.common.utils.ResultUtil;
import com.laycoding.entity.OssConfig;
import com.laycoding.mapper.OssConfigMapper;
import com.laycoding.service.IOssConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author laycoding
 * @since 2021-10-27
 */
@Service
public class OssConfigServiceImpl extends ServiceImpl<OssConfigMapper, OssConfig> implements IOssConfigService {

    @Value("${local-oss.windows}")
    private String windowsPath;

    @Value("${local-oss.linux}")
    private String linuxPath;

    @Override
    public ResultUtil<UploadInfoBO> uploadImage(HttpServletRequest req, MultipartFile file) {
        String path = LayUtils.isWindows() ? windowsPath : linuxPath;
        //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
        String destFileName = path + File.separator + fileName;
        Boolean isSuccess = OssUtils.uploadImage(path, destFileName, file);
        if (isSuccess) {
            UploadInfoBO uploadInfoBO = new UploadInfoBO();
            uploadInfoBO.setFileName(fileName);
            uploadInfoBO.setFilePath(path);
            uploadInfoBO.setFileUrl("/upload/" + fileName);
            uploadInfoBO.setFileType(0);

            return ResultUtil.success(uploadInfoBO);
        }
        return ResultUtil.success(null);
    }
}
