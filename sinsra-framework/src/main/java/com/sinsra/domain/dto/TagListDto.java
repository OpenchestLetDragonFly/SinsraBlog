package com.sinsra.domain.dto;/*
 * ClassName: TagListDto
 * Package: com.sinsra.domain.dto
 * @Create: 2024/5/8 20:54
 */

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "查询标签的请求参数dto") //这个是关于swagger的注解
public class TagListDto {

    //请求参数。用户可传可不传，这两个参数是给用户在搜索框根据name查询对应的标签，或根据remark查询对应的标签
    private String name;
    private String remark;

}
