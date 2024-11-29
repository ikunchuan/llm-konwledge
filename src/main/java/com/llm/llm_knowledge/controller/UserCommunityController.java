package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.UserCommunity;
import com.llm.llm_knowledge.service.UserCommunityService;
import com.llm.llm_knowledge.service.UserCommunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ucmns/v1")
public class UserCommunityController {
    
    @Autowired
    private UserCommunityService userCommunityService;
    
    //查询所有用户加入社区表,即所有社区及加入的用户
    @GetMapping("ucmn")
    public List<UserCommunity> allUcmn(){
        return userCommunityService.allUcmn();
    }
    
    //根据表的主键查询表
    @GetMapping("ucmn/{ucmnid}")
    public UserCommunity ucmnById(@PathVariable Integer ucmnid){
        return userCommunityService.ucmnById(ucmnid);
    }
    
    //增加表
    @PostMapping("ucmn")
    public Integer addUcmn(UserCommunity userCommunity){
        return userCommunityService.addUcmn(userCommunity);
    }
    
    //删除表
    @DeleteMapping("ucmn/{ucmnid}")
    public Integer delUcmn(@PathVariable Integer ucmnid){
        return userCommunityService.delUcmn(ucmnid);
    }
    
    //更新表
    @PutMapping("ucmn")
    public Integer updateUcmn(UserCommunity userCommunity){
        return userCommunityService.updateUcmn(userCommunity);
    }
    
    
}
