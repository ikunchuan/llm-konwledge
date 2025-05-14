package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CourseFavoriteDTO;
import com.llm.llm_knowledge.entity.CourseFavorite;
import com.llm.llm_knowledge.vo.CourseFavoriteSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseFavoriteMapper extends BaseMapper<CourseFavorite> {
    List<CourseFavoriteDTO> selectFavoritesByCourseName(CourseFavoriteSearch courseFavoriteSearch);
    List<CourseFavoriteDTO> getCourseFavoriteByUserId(Integer userId);
    Integer updateCourseFavorite(Integer userId, Integer courseId);
}
