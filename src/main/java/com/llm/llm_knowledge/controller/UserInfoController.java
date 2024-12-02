package com.llm.llm_knowledge.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.service.CommunityService;
import com.llm.llm_knowledge.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("uis/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    //更新用户
    @PutMapping("ui")
    public Integer updateUserInfoById(UserInfo userInfo){
        return userInfoService.updateUserInfoById(userInfo);
    };


    //分页查询全部记录
    @GetMapping("ui")
    public Page<UserInfo> findAllPageUserInfo(
            @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        return userInfoService.findAllPageUserInfo(pageNum,pageSize);
    };



    //条件查询
    @GetMapping("ui2")
    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo){
        return userInfoService.criteriaFindUserInfo(userInfo);
    };

    //    //根据id批量查询
//    @GetMapping("ui/{uiid}")
//    public List<UserInfo> findUserInfoByIds(List<UserInfo> ids){
//        return userInfoService.findUserInfoByIds(ids);
//    };
    //    //根据id查询
//    @GetMapping("ui/{uiid}")
//    public UserInfo findUserInfoById(Integer userId){
//        return userInfoService.findUserInfoById(userId);
//    };

}
