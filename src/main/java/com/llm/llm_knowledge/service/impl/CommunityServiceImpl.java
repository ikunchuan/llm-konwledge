package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<Community> allCmn(Integer currentSize, Integer currentNum) {
        Page<Community> page = new Page<>(currentSize,currentNum);
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
    public IPage<Community> cmnByCondi(Integer categoryId, String cmnName, Integer currentNum, Integer currentSize) {
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        
        // 添加 category_id 条件
        if (categoryId != null) {
            wrapper.eq("category_id", categoryId); // 假设你要用 category_id 查询
        }
        
        // 添加模糊查询条件
        if (cmnName != null && !cmnName.isEmpty()) {
            wrapper.like("community_name", cmnName);
        }
        
        Page<Community> page = new Page<>(currentNum, currentSize);
        
        return communityMapper.selectPage(page, wrapper);
    }
    
    
}
