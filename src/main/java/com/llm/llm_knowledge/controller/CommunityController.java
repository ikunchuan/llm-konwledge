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
    
    @GetMapping("cmn")          //查看所有的社区
    public List<Community> allCmn(){
        return communityService.allCmn();
    }
    
    @GetMapping("cmn/{cmnid}")          //根据社区的id来查询社区
    public Community cmnById(@PathVariable Integer cmnid){
        return communityService.cmnById(cmnid);
    }
    
    //localhost:8080/cmns/v1/cmn
    @PostMapping("cmn")                 //新增一个社区,传入的是一个community实体
    public Integer addCmn(Community community){
        return communityService.addCmn(community);
    }
    
    @DeleteMapping("cmn/{cmnid}")           //根据cmnid删除社区
    public Integer delCmn(@PathVariable Integer cmnid){
        return communityService.delCmn(cmnid);
    }
    
    @PutMapping("cmn")
    public Integer updateCmn(Community community){
        return communityService.updateCmn(community);
    }
    
    
    
}
