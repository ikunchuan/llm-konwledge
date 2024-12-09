package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseFavoriteDTO;
import com.llm.llm_knowledge.entity.CourseFavorite;
import com.llm.llm_knowledge.vo.CourseFavoriteSearch;

import java.util.List;

public interface CourseFavoriteService {
    Integer addCourseFavorite(CourseFavorite courseFavorite);
    Integer delCourseFavorite(Integer courseFavoriteId);
    Integer delCourseFavoriteByIds(List<Integer> Ids);
    PageInfo<CourseFavoriteDTO> search(CourseFavoriteSearch courseFavoriteSearch, Integer pageNum, Integer pageSize);
    Integer updateCourseFavorite(CourseFavorite courseFavorite);
}
