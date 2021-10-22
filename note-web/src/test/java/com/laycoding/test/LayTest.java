package com.laycoding.test;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laycoding.common.utils.ResultUtil;
import com.laycoding.service.IFolderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author laycoding
 * @date 2021/10/22
 **/
@SpringBootTest
public class LayTest {


    @Autowired
    IFolderService service;

    @Test
    public void test() {

        ResultUtil<Boolean> booleanResultUtil = service.deleteFolder("5e81927ae50d40aab837925617097636");
        System.out.println(booleanResultUtil);


    }
}
