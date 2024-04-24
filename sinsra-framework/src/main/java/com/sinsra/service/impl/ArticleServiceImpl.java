package com.sinsra.service.impl;/*
 * ClassName: ArticleServiceImpl
 * Package: com.sinsra.service.impl
 * @Create: 2024/4/23 21:43
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinsra.constants.SystemConstants;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Article;
import com.sinsra.mapper.ArticleMapper;
import com.sinsra.service.ArticleService;

import com.sinsra.util.BeanCopyUtils;
import com.sinsra.vo.HotArticleVO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查找10条（分页）
        Page<Article> page = new Page(SystemConstants.ARTICLE_STATUS_CURRENT,SystemConstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);
        List<Article> articles = page.getRecords();

        List<HotArticleVO> hotArticles = BeanCopyUtils.copyBeanList(articles,HotArticleVO.class);

        return ResponseResult.okResult(hotArticles);
    }
}
