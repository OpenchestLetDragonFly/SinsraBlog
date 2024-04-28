package com.sinsra.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2024-04-25 11:09:17
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
