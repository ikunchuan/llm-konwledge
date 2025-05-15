package com.llm.llm_knowledge.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.vo.CompetitionSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
@Mapper
public interface CompetitionMapper extends BaseMapper<Competition> {

    List<Competition> selectTopMatches(@Param("keywords") String keywordsJson);


    List<CompetitionDTO> selectCompetitionWithFilters(CompetitionSearch competitionSearch);
    
    
    
    CompetitionFavorite searchCompetitionFavorite(Integer userId, Integer competitionId);
    
    Integer addCompetitionFavorite(Integer userId, Integer competitionId);
    
    Integer updateFavoriteStatus(Integer userId, Integer competitionId);
    
    List<Integer> getChildByParent(Integer parentId);
    
    List<Competition> getCompeByIds(Integer childId);

    List<Competition> getCompByName(String competitionName);
}
