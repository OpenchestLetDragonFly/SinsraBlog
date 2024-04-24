package com.sinsra.vo;/*
 * ClassName: HotArticleVO
 * Package: com.sinsra.vo
 * @Create: 2024/4/24 15:38
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVO {
    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;
}
