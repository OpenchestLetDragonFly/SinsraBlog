package com.sinsra.domain.vo;/*
 * ClassName: LinkVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/4/25 11:13
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {
    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;
}
