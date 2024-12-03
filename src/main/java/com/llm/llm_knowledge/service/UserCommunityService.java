package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.UserCommunity;
import com.llm.llm_knowledge.entity.UserInfo;

import java.util.List;
import java.util.stream.BaseStream;

public interface UserCommunityService {
    
    List<UserCommunity> allUcmn();
    
    UserCommunity ucmnById(Integer ucmnid);
    
    Integer addUcmn(UserCommunity userCommunity);
    
    Integer delUcmn(Integer ucmnid);
    
    Integer updateUcmn(UserCommunity userCommunity);
    
    List<UserCommunity> allUsers(Integer cmnid);
}
