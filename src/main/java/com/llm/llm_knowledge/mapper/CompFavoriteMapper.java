package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.vo.CompFavoriteSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompFavoriteMapper extends BaseMapper<CompetitionFavorite> {
    List<CompFavoriteDTO> selectFavoritesByCompetitionName(CompFavoriteSearch compFavoriteSearch);
    
    List<CompFavoriteDTO> getCompFavoriteByUserId(Integer userId);

    Integer updateCompFavorite(Integer userId, Integer compId);
}
