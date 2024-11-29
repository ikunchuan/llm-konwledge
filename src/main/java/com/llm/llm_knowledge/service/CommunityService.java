package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Community;

import java.util.List;

public interface CommunityService {
    
    public List<Community> allCmn();
    
    public Community cmnById(Integer cmnid);
    
    public Integer addCmn(Community community);
    
    public Integer delCmn(Integer cmnid);
    
    public Integer updateCmn(Community community);
}
