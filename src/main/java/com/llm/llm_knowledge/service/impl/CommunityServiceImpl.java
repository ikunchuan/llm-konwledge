package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CommunityDTO;
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
    public IPage<Community> allCmn(Integer pageNum, Integer pageSize) {
        Page<Community> page = new Page<>(pageNum,pageSize);
        return communityMapper.selectPage(page,null);
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
//        log.info("查询社区: {},当前页: {},本页数:{}",communitySearch.toString(),pageNum,pageSize);
//        log.warn("查询社区: {},当前页: {},本页数:{}",communitySearch.toString(),pageNum,pageSize);
//        log.error("查询社区: {},当前页: {},本页数:{}",communitySearch.toString(),pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<CommunityDTO> communityDTOS = communityMapper.selectCommunitiesWithFilters(communitySearch);
        return new PageInfo<>(communityDTOS);
    }
    
    
    
}
