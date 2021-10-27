package com.laycoding.config;

import com.laycoding.common.utils.LayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author laycoding
 * @date 2021/10/27
 **/
@Configuration
public class FileMappingConfig extends WebMvcConfigurerAdapter {

    @Value("${local-oss.windows}")
    private String windowsPath;

    @Value("${local-oss.linux}")
    private String linuxPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Boolean windows = LayUtils.isWindows();
        if (windows) {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:" + windowsPath);
        } else {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:" + linuxPath);
        }
    }
}
