package com.laycoding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.laycdoing.mapper")
public class NoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoteApplication.class);
    }
}
