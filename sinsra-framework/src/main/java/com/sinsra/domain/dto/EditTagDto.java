package com.sinsra.domain.dto;/*
 * ClassName: EditTagDto
 * Package: com.sinsra.domain.dto
 * @Create: 2024/5/8 21:51
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTagDto {

    private Long id;
    //备注
    private String remark;
    //标签名
    private String name;
}
