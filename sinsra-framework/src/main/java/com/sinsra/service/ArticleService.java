package com.sinsra.service;/*
 * ClassName: ArticleService
 * Package: com.sinsra.service
 * @Create: 2024/4/23 21:42
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Article;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
