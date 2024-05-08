package com.sinsra;/*
 * ClassName: BlogAdminApplication
 * Package: com.sinsra
 * @Create: 2024/5/8 11:33
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //把这个类标识为引导类(也叫启动类)
@MapperScan("com.sinsra.mapper") //mybatis的配置
public class BlogAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class);
    }
}
