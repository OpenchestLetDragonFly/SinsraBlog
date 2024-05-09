package com.sinsra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinsra.domain.entity.ArticleTag;
import com.sinsra.mapper.ArticleTagMapper;
import com.sinsra.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签关联表(ArticleTag)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 10:37:37
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

}
