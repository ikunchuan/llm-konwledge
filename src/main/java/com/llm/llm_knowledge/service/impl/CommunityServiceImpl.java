package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.dto.UserPostCountDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.mapper.CommunityMapper;
import com.llm.llm_knowledge.service.CommunityService;
import com.llm.llm_knowledge.vo.CommunitySearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CommunityServiceImpl implements CommunityService {
    
    @Autowired
    private CommunityMapper communityMapper;
    
    //查询所有社区
    @Override
    public List<Community> allCmn() {
        return communityMapper.selectList(null);
    }
    
    //根据id查询
    @Override
    public Community cmnById(Integer cmnid) {
        return communityMapper.selectById(cmnid);
    }
    
    //增加社区
    @Override
    public Integer addCmn(Community community) {
        return communityMapper.insert(community);
    }
    
    //根据id删除社区
    @Override
    public Integer delCmn(Integer cmnid) {
        return communityMapper.deleteById(cmnid);
    }
    
    
    //更新社区
    @Override
    public Integer updateCmn(Community community) {
        return communityMapper.updateById(community);
    }
    
    
    
    
    
    
    //根据社区的种类标签输入的社区的名字来模糊查询
    @Override
    public PageInfo<CommunityDTO> search(@RequestBody CommunitySearch communitySearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CommunityDTO> communityDTOS = communityMapper.selectCommunitiesWithFilters(communitySearch);
        return new PageInfo<>(communityDTOS);
    }
    
    @Override
    public PageInfo<CommunityDTO> search2(@RequestBody CommunitySearch communitySearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CommunityDTO> communityDTOS = communityMapper.selectCommunitiesWithFilters2(communitySearch);
        return new PageInfo<>(communityDTOS);
    }
    
    
    
    @Override
    public List<UserPostCountDTO> getCommunityPostUser(Integer communityId) {
        return communityMapper.selectCommunityUsersWithPostCount(communityId);
    }
    

    
    @Override
    public Integer updateUserScoreForLogin(Integer communityId, Integer userId) {
        //首先查看用户在这个社区是否有积分表,如果没有则先插入数据,如果有则增加分数
        communityMapper.insertUserCommunityScoreIfNotExist(communityId,userId);
        communityMapper.updateUserScoreForLogin(communityId,userId);
        return null;
    }
    
    
}
