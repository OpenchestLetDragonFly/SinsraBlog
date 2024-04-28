package com.sinsra.service.impl;/*
 * ClassName: UserDetailsServiceImpl
 * Package: com.sinsra.service.impl
 * @Create: 2024/4/26 11:10
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sinsra.domain.LoginUser;
import com.sinsra.domain.entity.User;
import com.sinsra.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    //UserMapper是我们在framework工程mapper目录的接口
    private UserMapper userMapper;

    @Override
    //在这里之前，我们已经拿到了登录的用户名和密码。UserDetails是SpringSecurity官方提供的接口
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据拿到的用户名，并结合查询条件(数据库是否有这个用户名)，去查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);

        //判断是否查询到用户，也就是这个用户是否存在，如果没查到就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");//后期会对异常进行统一处理
        }

        //TODO 查询权限信息，并封装

        //返回查询到的用户信息。注意下面那行直接返回user会报错，我们需要在framework工程的domain目录新
        //建LoginUser类，在LoginUser类实现UserDetails接口，然后下面那行就返回LoginUser对象
        return new LoginUser(user);
    }
}
