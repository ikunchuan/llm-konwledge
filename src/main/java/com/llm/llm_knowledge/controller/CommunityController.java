package com.llm.llm_knowledge.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.dto.UserCommunityScoreDTO;
import com.llm.llm_knowledge.dto.UserPostCountDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.UserCommunityScore;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.mapper.CommunityMapper;
import com.llm.llm_knowledge.service.CommunityService;
import com.llm.llm_knowledge.util.FileUtil;
import com.llm.llm_knowledge.vo.CommunitySearch;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/cmns")
public class CommunityController {
    
    @Autowired
    private CommunityService communityService;
    
    @Autowired
    private CommunityMapper communityMapper;
    
    /**
     * 查看所有已注册的社区  无分页版
     *
     * @return List<Community>
     */
    @GetMapping("cmn")
    public List<Community> allCmn() {
        return communityService.allCmn();
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
     * 根据社区标签和名字进行模糊查询 这里查询的是已经审核过的社区
     *
     * @return List
     */
    @PostMapping("/search")
    public PageInfo<CommunityDTO> search(
            @RequestBody CommunitySearch communitySearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) throws BizException {
        return communityService.search(communitySearch, pageNum, pageSize);
    }
    
    
    /**
     * 根据社区标签和名字进行模糊查询 这里查询的是未审核过的社区
     *
     * @return List
     */
    @PostMapping("/search2")
    public PageInfo<CommunityDTO> search2(
            @RequestBody CommunitySearch communitySearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) throws BizException {
        return communityService.search2(communitySearch, pageNum, pageSize);
    }
    
    
    /**
     * 新增一个社区,传入的是一个community实体
     *
     * @return Integer<Community>
     */
    @PostMapping("/cmn")
    public Integer addCmn(@RequestBody Community community) {
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
    public Integer updateCmn(@RequestBody Community community) {
        return communityService.updateCmn(community);
    }
    
    
    /**这个功能是点击社区里面的所有用户,可以看到改社区的所有用户,以及用户名和在这个社区发布过的帖子的数量
     * @return List<UserPostCountDTO> 返回用户名和发帖的数量,例如"userName": "myc","postCount": 2 */
    @GetMapping("cmnpostuser/{communityId}")
    public List<UserPostCountDTO> getCommunityPostUser(@PathVariable Integer communityId){
        return communityService.getCommunityPostUser(communityId);
    }
    
    
    /**
     * 图片上传*/
    @PostMapping("/upload")
    public String getPicFileName(MultipartFile file){
        String oldFileName = file.getOriginalFilename();  // 获取原始文件名
        System.out.println(oldFileName);
        String typeName = oldFileName.substring(oldFileName.lastIndexOf('.'));  // 获取文件扩展名
        String filePath = FileUtil.getUpLoadFilePath();  // 获取文件保存路径
        System.out.println(typeName);
        String newFileName = System.currentTimeMillis() + oldFileName;  // 生成新文件名，防止覆盖
        
        try {
            // 保存文件到指定路径
            FileUtil.uploadFile(file.getBytes(), filePath, newFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);  // 如果上传失败，抛出运行时异常
        }
        
        return newFileName;  // 返回新文件名
    }
    
    
    
    
    /**用户登录社区增加积分*/
    @PutMapping("loginwithscore")
    public Integer updateUserScoreForLogin(@RequestParam Integer communityId,
                                           @RequestParam Integer userId){
        return communityService.updateUserScoreForLogin(communityId,userId);
    }
    
    
    
    /**查看社区里面的用户积分排行榜*/
    @GetMapping("comscore/{communityId}")
    public List<UserCommunityScoreDTO> checkCommuniutyScore(@PathVariable Integer communityId){
        return communityService.checkCommuniutyScore(communityId);
    }

    

    
}
