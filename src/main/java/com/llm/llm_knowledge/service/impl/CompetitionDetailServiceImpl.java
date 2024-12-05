package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.CompetitionDetail;
import com.llm.llm_knowledge.mapper.CompetitionDetailMapper;
import com.llm.llm_knowledge.service.CompetitionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompetitionDetailServiceImpl implements CompetitionDetailService {
    @Autowired
    private CompetitionDetailMapper competitionDetailMapper;

    //查询功能
    @Override
    public List<CompetitionDetail> allCompeDetail () {return competitionDetailMapper.selectList(null); }
    //根据ID进行查询
    @Override
    public CompetitionDetail compeDetailById(Integer compeid) { return competitionDetailMapper.selectById(compeid); }
    //添加插入
    @Override
    public Integer addCompeDetail(CompetitionDetail competitionDetail) {
        int i = competitionDetailMapper.insert(competitionDetail);
        System.out.println(i);
        System.out.println(competitionDetail);
        return i;
    }
    //进行删除--根据ID进行删除
    @Override
    public Integer deleteCompeDetail(Integer compeid) {
        Integer i = competitionDetailMapper.deleteById(compeid);
        System.out.println(i);
        return i;
    }
    //进行更新修改
    @Override
    public Integer updateCompeDetail(CompetitionDetail competitionDetail) {
        Integer i = competitionDetailMapper.updateById(competitionDetail);
        System.out.println(i);
        return i;
    }
    //分页查询
    @Override
    public Page<CompetitionDetail> compeDetailByPage (Integer pageNum, Integer pageSize) {
        Page<CompetitionDetail> page = new Page<>(pageNum, pageSize);
        Page<CompetitionDetail> competitionDetailPage = competitionDetailMapper.selectPage(page, null);
        competitionDetailPage.getRecords().forEach(System.out::println);
        return competitionDetailPage;

    }



















}
