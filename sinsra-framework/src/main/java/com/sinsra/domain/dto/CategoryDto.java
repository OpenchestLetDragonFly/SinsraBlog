package com.sinsra.domain.dto;/*
 * ClassName: CategoryDto
 * Package: com.sinsra.domain.dto
 * @Create: 2024/5/9 11:38
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    //分类名
    private String name;
    //描述
    private String description;
    //状态0:正常,1禁用
    private String status;
}
