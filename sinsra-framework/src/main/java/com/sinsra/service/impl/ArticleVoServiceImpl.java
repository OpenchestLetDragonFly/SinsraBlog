package com.sinsra.service.impl;/*
 * ClassName: ArticleVoServiceImpl
 * Package: com.sinsra.service.impl
 * @Create: 2024/5/9 21:38
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinsra.domain.vo.ArticleVo;
import com.sinsra.mapper.ArticleVoMapper;
import com.sinsra.service.ArticleVoService;
import org.springframework.stereotype.Service;

@Service
public class ArticleVoServiceImpl extends ServiceImpl<ArticleVoMapper, ArticleVo> implements ArticleVoService {

}
