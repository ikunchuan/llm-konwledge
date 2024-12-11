package com.llm.llm_knowledge.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : symao
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String test() {
        System.err.println(StpUtil.getTokenValue());
        return "test";
    }

}
