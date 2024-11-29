package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.UserCommunity;

import java.util.List;

public interface UserCommunityService {
    
    List<UserCommunity> allUcmn();
    
    
    UserCommunity ucmnById(Integer ucmnid);
    
    
    Integer addUcmn(UserCommunity userCommunity);
    
    
    Integer delUcmn(Integer ucmnid);
    
    Integer updateUcmn(UserCommunity userCommunity);
}
