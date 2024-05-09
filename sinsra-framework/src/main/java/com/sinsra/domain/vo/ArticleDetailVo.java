package com.sinsra.domain.vo;/*
 * ClassName: ArticleDetailVo
 * Package: com.sinsra.domain.vo
 * @Create: 2024/4/25 10:19
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //所属分类id
    private Long categoryId;
    //所属分类名
    private String categoryName;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    private Date createTime;

}
