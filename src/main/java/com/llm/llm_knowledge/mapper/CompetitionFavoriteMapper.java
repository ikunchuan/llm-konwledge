package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompetitionFavoriteMapper extends BaseMapper<CompetitionFavorite> {

    // 查询所有收藏记录
    @Select("SELECT user_id, competition_id FROM competition_favorite WHERE deleted = 0")
    List<CompetitionFavorite> getAllFavorites();
}
