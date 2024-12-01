package com.llm.llm_knowledge.service.impl;

import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.UserCommunity;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.mapper.UserCommunityMapper;
import com.llm.llm_knowledge.service.CompetitionService;
import com.llm.llm_knowledge.service.UserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommunityServiceImpl implements UserCommunityService {
    
    @Autowired
    private UserCommunityMapper userCommunityMapper;
    
    @Override
    public List<UserCommunity> allUcmn() {
        return userCommunityMapper.selectList(null);
    }
    
    @Override
    public UserCommunity ucmnById(Integer ucmnid) {
        return userCommunityMapper.selectById(ucmnid);
    }
    
    @Override
    public Integer addUcmn(UserCommunity userCommunity) {
        return userCommunityMapper.insert(userCommunity);
    }
    
    @Override
    public Integer delUcmn(Integer ucmnid) {
        return userCommunityMapper.deleteById(ucmnid);
    }
    
    @Override
    public Integer updateUcmn(UserCommunity userCommunity) {
        return userCommunityMapper.updateById(userCommunity);
    }


}
