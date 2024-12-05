package com.llm.llm_knowledge.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.vo.CompetitionSearch;

import java.util.List;

public interface CompetitionMapper  extends BaseMapper<Competition> {

    List<CompetitionDTO> selectCompetitionWithFilters(CompetitionSearch competitionSearch);

}
