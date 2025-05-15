package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.vo.CompFavoriteSearch;

import java.util.List;

public interface CompFavoriteService {

    //取消收藏
    Integer delCompFavorite(Integer competitionFavoriteId);

    //批量删除
    Integer delCompFavoriteByIds(List<Integer> Ids);

    //分页查询
    PageInfo<CompFavoriteDTO> search(CompFavoriteSearch compSearch, Integer pageNum, Integer pageSize);

    //userId获取收藏夹
    List<CompFavoriteDTO> getCompFavoriteByUserId(Integer userId);


    Integer updateCompFavorite(Integer userId, Integer compId);

    boolean isCollected(Integer userId, Integer compId);
}
