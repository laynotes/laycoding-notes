package com.laycoding.generator;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;

public class Generator {
    public static void main(String[] args) {


        final String outDir = "E://JavaProjects/laycoding-notes/note-generator";

        FastAutoGenerator.create("jdbc:mysql://47.96.248.205:3306/laycoding_notes?serverTimezone=UTC&useSSL=false", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("laycoding") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.laycoding") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, outDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_oss_config")
                            .addTablePrefix("sys_", "sys_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
