package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.vo.CommunitySearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityMapper extends BaseMapper<Community> {
    
    List<CommunityDTO> selectCommunitiesWithFilters(CommunitySearch communitySearch);

}
