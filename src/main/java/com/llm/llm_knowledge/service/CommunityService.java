package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.dto.UserCommunityScoreDTO;
import com.llm.llm_knowledge.dto.UserPostCountDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.UserCommunityScore;
import com.llm.llm_knowledge.vo.CommunitySearch;

import java.util.List;

public interface CommunityService {
    
    //查询所有社区
    public List<Community> allCmn();
    
    //根据cmnid查询社区
    public Community cmnById(Integer cmnid);
    
    //增加社区
    public Integer addCmn(Community community);
    
    //删除社区
    public Integer delCmn(Integer cmnid);
    
    //更新社区
    public Integer updateCmn(Community community);
    
    
    //模糊查询社区
    PageInfo<CommunityDTO> search(CommunitySearch communitySearch, Integer  pageNum, Integer pageSize);
    
    PageInfo<CommunityDTO> search2(CommunitySearch communitySearch, Integer pageNum, Integer pageSize);
    
    
    
    List<UserPostCountDTO> getCommunityPostUser(Integer communityId);
    
    
    Integer updateUserScoreForLogin(Integer communityId, Integer userId);
    
    List<UserCommunityScoreDTO> checkCommuniutyScore(Integer communityId);
}
