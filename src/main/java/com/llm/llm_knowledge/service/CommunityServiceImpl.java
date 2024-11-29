package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommunityServiceImpl implements CommunityService{
    
    @Autowired
    private CommunityMapper communityMapper;
    
    @Override
    public List<Community> allCmn() {
        return communityMapper.selectList(null);
    }
    
    @Override
    public Community cmnById(Integer cmnid) {
        return communityMapper.selectById(cmnid);
    }
    
    @Override
    public Integer addCmn(Community community) {
        return communityMapper.insert(community);
    }
    
    @Override
    public Integer delCmn(Integer cmnid) {
        return communityMapper.deleteById(cmnid);
    }
    
    @Override
    public Integer updateCmn(Community community) {
        return communityMapper.updateById(community);
    }
    
    
}
