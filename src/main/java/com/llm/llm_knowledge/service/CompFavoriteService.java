package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.vo.CompFavoriteSearch;

import java.util.List;

public interface CompFavoriteService {
    //添加
    Integer addCompFavorite(CompetitionFavorite competitionFavorite);

    //单删
    Integer delCompFavorite(Integer competitionFavoriteId);

    //批量删除
    Integer delCompFavoriteByIds(List<Integer> Ids);

    //更新
    Integer updCompFavorite(CompetitionFavorite competitionFavorite);

    //分页查询
    PageInfo<CompFavoriteDTO> search(CompFavoriteSearch compSearch, Integer pageNum, Integer pageSize);

    //userId获取收藏夹
    List<Competition> getCompFavoriteByUserId(Integer userId);
}
