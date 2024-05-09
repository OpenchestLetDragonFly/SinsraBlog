package com.sinsra.controller;/*
 * ClassName: ArticleController
 * Package: com.sinsra.controller
 * @Create: 2024/4/23 21:53
 */

import com.sinsra.annotation.mySystemLog;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.dto.AddArticleDto;
import com.sinsra.domain.dto.ArticleDto;
import com.sinsra.domain.entity.Article;
import com.sinsra.domain.vo.ArticleByIdVo;
import com.sinsra.domain.vo.ArticleVo;
import com.sinsra.domain.vo.PageVo;
import com.sinsra.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }


    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize){
        PageVo pageVo = articleService.selectArticlePage(article,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    @GetMapping(value = "/{id}")
    //①先查询根据文章id查询对应的文章
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        ArticleByIdVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    @PutMapping
    //②然后才是修改文章
    public ResponseResult edit(@RequestBody ArticleDto article){
        articleService.edit(article);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        //直接使用mybatisplus提供的removeById方法
        articleService.removeById(id);
        return ResponseResult.okResult();
    }
}
