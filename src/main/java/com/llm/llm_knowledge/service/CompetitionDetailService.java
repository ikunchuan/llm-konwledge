package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.CompetitionDetail;

import java.util.List;

public interface CompetitionDetailService {
    //查询竞赛详情信息
    List<CompetitionDetail> allCompeDetail();
    //条件查询
    CompetitionDetail compeDetailById(Integer compedetailid);
    //增加竞赛详情信息
    Integer addCompeDetail(CompetitionDetail competitionDetail);
    //删除竞赛详情信息
    Integer deleteCompeDetail(Integer compedetailid);
    //更新竞赛详情信息
    Integer updateCompeDetail(CompetitionDetail competitionDetail);

}
