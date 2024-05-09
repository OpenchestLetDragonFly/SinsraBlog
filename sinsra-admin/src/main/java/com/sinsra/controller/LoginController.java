package com.sinsra.controller;/*
 * ClassName: LoginController
 * Package: com.sinsra.controller
 * @Create: 2024/5/8 12:45
 */

import com.sinsra.annotation.mySystemLog;
import com.sinsra.domain.LoginUser;
import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.entity.Menu;
import com.sinsra.domain.entity.User;
import com.sinsra.enums.AppHttpCodeEnum;
import com.sinsra.exception.SystemException;
import com.sinsra.service.MenuService;
import com.sinsra.service.RoleService;
import com.sinsra.service.SystemLoginService;
import com.sinsra.util.BeanCopyUtils;
import com.sinsra.util.RedisCache;
import com.sinsra.util.SecurityUtils;
import com.sinsra.domain.vo.AdminUserInfoVo;
import com.sinsra.domain.vo.RoutersVo;
import com.sinsra.domain.vo.UserInfoVo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class LoginController {

    @Resource
    private SystemLoginService systemLoginService;

    @Resource
    MenuService menuService;
    @Resource
    RoleService roleService;
    @Resource
    RedisCache redisCache;

    @PostMapping("/user/login")
    @mySystemLog(businessName = "请求后台登陆")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return systemLoginService.login(user);
    }


    @GetMapping("/getInfo")
    @mySystemLog(businessName = "获得权限信息")
    public ResponseResult<AdminUserInfoVo> getInfo(){
        //获取当前登录的用户。SecurityUtils是我们在sinsra-framework写的类
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        //BeanCopyUtils是我们在sinsra-framework写的类
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        //封装响应返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }


    @GetMapping("/getRouters")
    @mySystemLog(businessName = "获得路由表（权限相关）")
    //RoutersVo是我们在sinsra-framework工程写的类
    public ResponseResult<RoutersVo> getRouters(){
        //获取用户id
        Long userId = SecurityUtils.getUserId();

        //根据用户id来查询menu(权限菜单)。要求查询结果是tree的形式，也就是子父菜单树
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装响应返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }


    @PostMapping("/user/logout")
    @mySystemLog(businessName = "退出后台登录")
    public ResponseResult logout(){
        //退出登录
        return systemLoginService.logout();
    }

}

