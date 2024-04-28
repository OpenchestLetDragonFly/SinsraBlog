package com.sinsra.config;/*
 * ClassName: SecurityConfig
 * Package: com.sinsra.config
 * @Create: 2024/4/26 11:07
 */

import com.sinsra.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在sinsra-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()
                .antMatchers("/link/getAllLink").authenticated()
                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        http.logout().disable();

        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
        //允许跨域
        http.cors();
    }

}
