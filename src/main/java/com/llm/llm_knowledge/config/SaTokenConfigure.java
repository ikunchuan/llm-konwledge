package com.llm.llm_knowledge.config;

import cn.dev33.satoken.fun.SaParamFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 该方法用于校验用户登录
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能 
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(new SaParamFunction() {
                    @Override
                    public void run(Object o) {
                        // 登录校验
                        StpUtil.checkLogin();
                    }
                }))
                .addPathPatterns("/**")
                .excludePathPatterns(whiteList());
    }

    /**
     * 放行白名单
     * @return
     */
    public List<String> whiteList() {
        List<String> whiteList = new ArrayList<>();
        whiteList.add("/admin/user/login");
        whiteList.add("/test/hello");
        whiteList.add("/admin/user/logout");
        return whiteList;
    }

}
