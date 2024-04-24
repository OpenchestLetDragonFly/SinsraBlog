package com.sinsra.controller;/*
 * ClassName: ArticleController
 * Package: com.sinsra.controller
 * @Create: 2024/4/23 21:53
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Article;
import com.sinsra.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        //查询热门文章
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId){
        return articleService.articleList(pageNum, pageSize, categoryId);

    }

    public ResponseResult getArticleDetail(){

    }

}
