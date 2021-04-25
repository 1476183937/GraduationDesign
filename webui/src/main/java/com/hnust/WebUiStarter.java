package com.hnust;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title:
 * @Author: ggh
 * @Date: 2020/5/12 21:48
 */

@SpringBootApplication
@MapperScan(basePackages = "com.hnust.mapper")
//@EnableDiscoveryClient
public class WebUiStarter {

    public static void main(String[] args) {
        SpringApplication.run(WebUiStarter.class, args);
    }

}
