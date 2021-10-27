package com.laycoding.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author laycoding
 * @date 2021/10/27
 **/
public class OssUtils {


    /**
     * 上传图片
     * @param path
     * @param fileName
     * @param file
     * @return
     */
    public static Boolean uploadImage(String path, String fileName, MultipartFile file) {
        try {
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(fileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
