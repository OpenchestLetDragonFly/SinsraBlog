package com.sinsra.config;/*
 * ClassName: SwaggerConfig
 * Package: com.sinsra.config
 * @Create: 2024/5/7 20:46
 */

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //标识为配置类
@EnableSwagger2 //开启swagger，即可通过swagger为huanf-blog工程生成接口文档
public class SwaggerConfig {

}

