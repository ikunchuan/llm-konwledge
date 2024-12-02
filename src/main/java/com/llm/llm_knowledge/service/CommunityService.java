package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Community;

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
    List<Community> cmnByCondi(String condi);
}
