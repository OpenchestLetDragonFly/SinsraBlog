package com.sinsra.controller;/*
 * ClassName: ArticleController
 * Package: com.sinsra.controller
 * @Create: 2024/4/23 21:53
 */

import com.sinsra.annotation.mySystemLog;
import com.sinsra.domain.ResponseResult;
import com.sinsra.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @mySystemLog(businessName = "根据文章id从mysql查询文章")//接口描述，根据Id找到文章
    public ResponseResult getArticleDetail(@PathVariable("id")Long id){
        return articleService.getArticleDetail(id);
    }

    @PutMapping("/updateViewCount/{id}")
    @mySystemLog(businessName = "文章阅读次数+1")//接口描述，用于'日志记录'功能
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }


}
