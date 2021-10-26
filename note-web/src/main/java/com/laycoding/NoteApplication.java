package com.laycoding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

/**
 * @author laycoding
 */
@SpringBootApplication
@MapperScan("com.laycdoing.mapper")
public class NoteApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(NoteApplication.class);
    }
}
