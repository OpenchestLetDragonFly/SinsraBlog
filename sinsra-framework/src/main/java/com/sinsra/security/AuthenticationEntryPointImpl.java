package com.sinsra.security;/*
 * ClassName: AuthenticationEntryPointImpl
 * Package: com.sinsra.security
 * @Create: 2024/4/28 21:59
 */


import com.alibaba.fastjson.JSON;
import com.sinsra.domain.ResponseResult;
import com.sinsra.enums.AppHttpCodeEnum;
import com.sinsra.util.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        e.printStackTrace();

        ResponseResult result = null;

        if(e instanceof BadCredentialsException){
            result = ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(),e.getMessage());
        } else if(e instanceof InsufficientAuthenticationException){
            result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }else{
            result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),"认证或授权失败");
        }

        WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));

    }
}
