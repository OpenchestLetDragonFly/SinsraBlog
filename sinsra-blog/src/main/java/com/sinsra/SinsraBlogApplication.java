package com.sinsra;/*
 * ClassName: SinsraBlogApplication
 * Package: com.sinsra
 * @Create: 2024/4/23 21:58
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sinsra.mapper")
public class SinsraBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SinsraBlogApplication.class,args);
    }
}
