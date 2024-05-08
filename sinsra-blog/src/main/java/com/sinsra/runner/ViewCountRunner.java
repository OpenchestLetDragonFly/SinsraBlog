package com.sinsra.runner;/*
 * ClassName: ViewCountRunner
 * Package: com.sinsra.runner
 * @Create: 2024/5/7 17:41
 */

import com.sinsra.domain.entity.Article;
import com.sinsra.mapper.ArticleMapper;
import com.sinsra.util.RedisCache;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
//项目每次启动把博客的浏览量（id和viewCount字段）存储到redis中，CommandLineRunner是spring提供的接口
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    RedisCache redisCache;

    @Resource
    ArticleMapper articleMapper;

    @Override
    public void run(String... args) throws Exception {
        List<Article> articleList = articleMapper.selectList(null);
        Map<String, Integer> viewCountMap = articleList.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));
        //把查询到的id作为key，viewCount作为value，一起存入Redis
        redisCache.setCacheMap("article:viewCount",viewCountMap);
    }

    //@Override
    ////下面的写法是stream流+函数式编程
    //public void run(String... args) throws Exception {
    //    //查询数据库中的博客信息，注意只需要查询id、viewCount字段的博客信息
    //    List<Article> articles = articleMapper.selectList(null);//为null即无条件，表示查询所有
    //    articles.stream()
    //            //由于我们需要key、value的数据，所有可以通过stream流，转为map集合。new Function表示函数式编程
    //            .collect(Collectors.toMap(new Function<Article, Long>() {
    //                @Override
    //                public Long apply(Article article) {
    //                    return article.getId();
    //                }
    //            }, new Function<Article, Integer>() {//new Function表示函数式编程
    //                @Override
    //                public Integer apply(Article article) {
    //                    return article.getViewCount().intValue();
    //                }
    //            }));
}
