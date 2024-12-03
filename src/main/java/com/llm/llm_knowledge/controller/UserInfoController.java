package com.llm.llm_knowledge.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.service.CommunityService;
import com.llm.llm_knowledge.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("uis/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    //查询全部
    @GetMapping("/ui")
    public IPage<UserInfo> allUser(@RequestParam (value = "pageNum") Integer pageNum,
                                   @RequestParam(value = "pageSize") Integer pageSize){
        return userInfoService.allUser(pageNum,pageSize);
    }
    //更新用户
//    @PutMapping("/ui/id")
//    public Integer updateUserInfoById(@RequestBody UserInfo userInfo){
//        return userInfoService.updateUserInfoById(userInfo);
//    };

    @PutMapping("/ui/{id}")
    public Integer updateUserInfoById(@PathVariable Integer id, @RequestBody UserInfo userInfo){
        userInfo.setUserId(id);  // 设置ID
        return userInfoService.updateUserInfoById(userInfo);
    }


    //分页查询全部记录
    @GetMapping("/pages")
    public IPage<UserInfo> searchUserInfo(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) String userName,
            Integer pageNum,
            Integer pageSize) {
        return userInfoService.uiByUserid(userId, userName, pageNum, pageSize);
    }



//    //条件查询
//    @GetMapping("/ui/details")
//    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo){
//        return userInfoService.criteriaFindUserInfo(userInfo);
//    };

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
