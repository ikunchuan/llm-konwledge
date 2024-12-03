package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.vo.CommunitySearch;

public interface CommunityService {
    
    //查询所有社区
    public IPage<Community> allCmn(Integer pageNum, Integer pageSize);
    
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
    
    void test();
}
