package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.UserCommunity;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.mapper.UserCommunityMapper;
import com.llm.llm_knowledge.service.CompetitionService;
import com.llm.llm_knowledge.service.UserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserCommunityServiceImpl implements UserCommunityService {
    
    @Autowired
    private UserCommunityMapper userCommunityMapper;
    
    //查询所有的用户社区表
    @Override
    public List<UserCommunity> allUcmn() {
        return userCommunityMapper.selectList(null);
    }
    
    //根据id查询用户社区表
    @Override
    public UserCommunity ucmnById(Integer ucmnid) {
        return userCommunityMapper.selectById(ucmnid);
    }
    
    //新增用户社区表
    @Override
    public Integer addUcmn(UserCommunity userCommunity) {
        return userCommunityMapper.insert(userCommunity);
    }
    
    //根据id删除用户信息表
    @Override
    public Integer delUcmn(Integer ucmnid) {
        return userCommunityMapper.deleteById(ucmnid);
    }
    
    //更新用户信息表
    @Override
    public Integer updateUcmn(UserCommunity userCommunity) {
        return userCommunityMapper.updateById(userCommunity);
    }
    
    //查询一个社区中的所有用户
    @Override
    public List<UserCommunity> allUsers(Integer cmnid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("community_id",cmnid);
        return userCommunityMapper.selectList(wrapper);
    }
    
    
}
