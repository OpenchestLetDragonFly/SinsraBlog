package com.sinsra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinsra.domain.entity.UserRole;
import com.sinsra.mapper.UserRoleMapper;
import com.sinsra.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户和角色关联表(UserRole)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 16:56:35
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
