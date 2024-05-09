package com.sinsra.service;/*
 * ClassName: ArticleService
 * Package: com.sinsra.service
 * @Create: 2024/4/23 21:42
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.dto.AddArticleDto;
import com.sinsra.domain.dto.ArticleDto;
import com.sinsra.domain.entity.Article;
import com.sinsra.domain.vo.ArticleByIdVo;
import com.sinsra.domain.vo.ArticleVo;
import com.sinsra.domain.vo.PageVo;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    //新增博客文章
    ResponseResult add(AddArticleDto article);

    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);


    //修改文章-①根据文章id查询对应的文章
    ArticleByIdVo getInfo(Long id);

    //修改文章-②然后才是修改文章
    void edit(ArticleDto article);

}
