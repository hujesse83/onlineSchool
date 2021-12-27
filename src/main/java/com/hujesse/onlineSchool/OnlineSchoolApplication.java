package com.hujesse.onlineSchool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hujesse.onlineSchool.mapper")
public class OnlineSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineSchoolApplication.class, args);
    }

}
