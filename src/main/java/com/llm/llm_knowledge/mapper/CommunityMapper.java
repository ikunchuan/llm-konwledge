package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.dto.UserCommunityScoreDTO;
import com.llm.llm_knowledge.dto.UserPostCountDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.UserCommunityScore;
import com.llm.llm_knowledge.vo.CommunitySearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityMapper extends BaseMapper<Community> {
    
    //通过审核
    List<CommunityDTO> selectCommunitiesWithFilters(CommunitySearch communitySearch);
    
    //
    List<CommunityDTO> selectCommunitiesWithFilters2(CommunitySearch communitySearch);
    
    
    List<UserPostCountDTO> selectCommunityUsersWithPostCount(Integer communityId);
    
    
    void insertUserCommunityScoreIfNotExist(Integer communityId, Integer userId);
    
    void updateUserScoreForLogin(Integer communityId, Integer userId);
    
    List<UserCommunityScoreDTO> checkCommuniutyScore(Integer communityId);
    
    List<Integer> getChildByParent(Integer parentId);
    
    List<Community> getCmnByIds(Integer parentId);
}
