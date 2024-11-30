package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.UserCommunity;
import com.llm.llm_knowledge.service.UserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ucmns/v1")
public class UserCommunityController {
    
    @Autowired
    private UserCommunityService userCommunityService;
    
    
    /**
    * 查询所有用户加入社区表,即所有社区及加入的用户
    *@return  List<UserCommunity> */
    @GetMapping("ucmn")
    public List<UserCommunity> allUcmn(){
        return userCommunityService.allUcmn();
    }
    
    
    /**根据表的主键查询表
     * @return UserCommunity*/
    @GetMapping("ucmn/{ucmnid}")
    public UserCommunity ucmnById(@PathVariable Integer ucmnid){
        return userCommunityService.ucmnById(ucmnid);
    }
    
    
    /**用户增加社区,前端传入json格式的东西,通过@RequestBody注解解析成实体类调用service层进行增加操作
     * @return Integer
     * */
    @PostMapping("ucmn")
    public Integer addUcmn(@RequestBody UserCommunity userCommunity){
        return userCommunityService.addUcmn(userCommunity);
    }
    
    
    /**管理员可以删除用户社区用户对应表,表的唯一标识ucmnid
     * @return Integer*/
    @DeleteMapping("ucmn/{ucmnid}")
    public Integer delUcmn(@PathVariable Integer ucmnid){
        return userCommunityService.delUcmn(ucmnid);
    }
    
    
    /**管理员对用户的信息可以进行更新,更新时传入整个UserCommunity
     * @return Integer*/
    @PutMapping("ucmn")
    public Integer updateUcmn(@RequestBody UserCommunity userCommunity){
        return userCommunityService.updateUcmn(userCommunity);
    }
    
    
}
