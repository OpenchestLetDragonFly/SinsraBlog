package com.sinsra.domain.vo;/*
 * ClassName: TagVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/5/8 22:19
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVo {

    private Long id;
    private String name;
    private String remark;
}

