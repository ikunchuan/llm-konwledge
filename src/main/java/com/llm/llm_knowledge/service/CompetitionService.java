package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Competition;

import java.util.List;

public interface CompetitionService {
    //查询所有
    List<Competition> allCompe();
    //条件查询
    Competition compeById(Integer compeid);
    //增加比赛
    Integer addCompe(Competition competition);
    //删除比赛
    Integer delCompe(Integer compeid);
    //更新
    Integer updateCompe(Competition competition);
    //分页查询
    Page<Competition> compePage(Integer pageNum, Integer pageSize);


}

