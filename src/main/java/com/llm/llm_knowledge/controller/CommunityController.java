package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cmns/v1")
public class CommunityController {
    
    @Autowired
    private CommunityService communityService;
    
    /**管理员查看所有已注册的社区
     * @return List<Community>*/
    @GetMapping("cmn")
    public List<Community> allCmn(){
        return communityService.allCmn();
    }
    
    /**根据社区的id来查询社区
     * @return Community*/
    @GetMapping("cmn/{cmnid}")
    public Community cmnById(@PathVariable Integer cmnid){
        return communityService.cmnById(cmnid);
    }
    
    
    /**新增一个社区,传入的是一个community实体
     * @return Integer<Community>*/
    @PostMapping("cmn")
    public Integer addCmn(Community community){
        return communityService.addCmn(community);
    }
    
    /**根据cmnid删除社区
     * @return Integer*/
    @DeleteMapping("cmn/{cmnid}")
    public Integer delCmn(@PathVariable Integer cmnid){
        return communityService.delCmn(cmnid);
    }
    
    /**新根据cmnid删除社区
     * @return Integer*/
    @PutMapping("cmn")
    public Integer updateCmn(Community community){
        return communityService.updateCmn(community);
    }
    
    
    
}
