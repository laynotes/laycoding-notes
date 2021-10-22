package com.laycoding.common.utils;

import java.util.UUID;

/**
 * @author laycoding
 * @date 2021/10/22
 **/
public class LayUtils {


    /**
     * 获取uuid
     * @return
     */
    public static String getUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }


}
