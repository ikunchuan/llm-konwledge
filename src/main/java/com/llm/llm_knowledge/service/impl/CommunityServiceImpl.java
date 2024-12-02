package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.mapper.CommunityMapper;
import com.llm.llm_knowledge.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    
    //根据输入的社区的名字来模糊查询
    @Override
    public List<Community> cmnByCondi(String condi) {
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        wrapper.like("community_name",condi);
        return communityMapper.selectList(wrapper);
    }
    
    
}
