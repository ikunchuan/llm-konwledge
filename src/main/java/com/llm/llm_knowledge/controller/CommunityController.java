package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("cmns/v1")
public class CommunityController {
    
    @Autowired
    private CommunityService communityService;
    
    /**
     * 管理员查看所有已注册的社区
     *
     * @return List<Community>
     */
    @GetMapping("cmn")
    public IPage<Community> allCmn(@RequestParam(value = "pageNum") Integer pageNum,
                                   @RequestParam(value = "pageSize") Integer pageSize) {
        return communityService.allCmn(pageNum, pageSize);
    }
    
    
    /**
     * 根据社区id查询社区
     *
     * @return Community
     */
    @GetMapping("cmn/{cmnid}")
    public Community cmnById(@PathVariable Integer cmnid) {
        return communityService.cmnById(cmnid);
    }
    
    
    /**
     * 根据社区标签和社区名字进行模糊查询
     *
     * @return List
     */
    @GetMapping("cmn/search")
    public IPage<Community> searchCommunities(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String cmnName,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        return communityService.cmnByCondi(categoryId, cmnName, pageNum, pageSize);
    }
    
    
    /**
     * 新增一个社区,传入的是一个community实体
     *
     * @return Integer<Community>
     */
    @PostMapping("cmn")
    public Integer addCmn(Community community) {
        return communityService.addCmn(community);
    }
    
    
    /**
     * 根据cmnid删除社区
     *
     * @return Integer
     */
    @DeleteMapping("cmn/{cmnid}")
    public Integer delCmn(@PathVariable Integer cmnid) {
        return communityService.delCmn(cmnid);
    }
    
    
    /**
     * 根据cmnid更新社区
     *
     * @return Integer
     */
    @PutMapping("cmn")
    public Integer updateCmn(Community community) {
        return communityService.updateCmn(community);
    }
    
    
}
