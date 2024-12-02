package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public  class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;

    //查询
    @Override
    public List<Competition> allCompe() {return competitionMapper.selectList(null);}

    //根据ID进行查询
    @Override
    public Competition compeById(Integer compeid) {return competitionMapper.selectById(compeid);}

    //添加插入
    @Override
    public Integer addCompe(Competition competition) {
        int result = competitionMapper.insert(competition);
        System.out.println(result);
        System.out.println(competition);
        return result;
    }

    //进行删除--根据ID删除
    @Override
    public Integer delCompe(Integer compeid) {
        Integer result02 = competitionMapper.deleteById(compeid);
        System.out.println(result02);
        return result02;}

    //批量删除


    //进行更新修改
    @Override
    public Integer updateCompe(Competition competition) {
        Integer result02 = competitionMapper.updateById(competition);
        System.out.println(result02);
        return result02;}

    //分页查询
    @Override
    public Page<Competition> compePage(Integer pageNum, Integer pageSize) {
        Page<Competition> page = new Page<>(pageNum, pageSize);
        Page<Competition> competitionPage = competitionMapper.selectPage(page, null);
        competitionPage.getRecords().forEach(System.out::println);
        return competitionPage;
    }



}
