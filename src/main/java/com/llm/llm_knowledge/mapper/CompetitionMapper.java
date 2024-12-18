package com.llm.llm_knowledge.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.vo.CompetitionSearch;

import java.util.ArrayList;
import java.util.List;

public interface CompetitionMapper  extends BaseMapper<Competition> {


    List<CompetitionDTO> selectCompetitionWithFilters(CompetitionSearch competitionSearch);
    
    
    
    CompetitionFavorite searchCompetitionFavorite(Integer userId, Integer competitionId);
    
    Integer addCompetitionFavorite(Integer userId, Integer competitionId);
    
    Integer updateFavoriteStatus(Integer userId, Integer competitionId);
    
    List<Integer> getChildByParent(Integer parentId);
    
    List<Competition> getCompeByIds(Integer childId);
}
