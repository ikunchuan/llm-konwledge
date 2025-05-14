package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseFavoriteDTO;
import com.llm.llm_knowledge.vo.CourseFavoriteSearch;

import java.util.List;

public interface CourseFavoriteService {
    //单删
    Integer delCourseFavorite(Integer id);
    Integer delCourseFavoriteByIds(List<Integer> Ids);
    PageInfo<CourseFavoriteDTO> search(CourseFavoriteSearch courseFavoriteSearch, Integer pageNum, Integer pageSize);
    List<CourseFavoriteDTO> getCourseFavoriteByUserId(Integer userId);
    Integer updateCourseFavorite(Integer userId, Integer courseId);
    boolean isCollected(Integer userId, Integer courseId);
}
