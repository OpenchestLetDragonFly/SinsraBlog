package com.sinsra.domain.dto;/*
 * ClassName: AddTagDto
 * Package: com.sinsra.domain.dto
 * @Create: 2024/5/8 21:24
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTagDto {

    private String remark;
    private String name;

}
