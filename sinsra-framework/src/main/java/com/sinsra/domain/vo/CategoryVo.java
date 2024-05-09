package com.sinsra.domain.vo;/*
 * ClassName: CategoryVO
 * Package: com.sinsra.domain.vo
 * @Create: 2024/4/24 17:35
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {
    Long id;
    String name;


    //描述
    private String description;
}
