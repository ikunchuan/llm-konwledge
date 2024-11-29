package com.llm.llm_knowledge;

import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.UserCommunity;
import com.llm.llm_knowledge.mapper.CommunityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LlmKnowledgeApplicationTests {
    
    @Autowired
    private CommunityMapper communityMapper;

    
    @Test
    public void testSelect(){
        List<Community> communities = communityMapper.selectList(null);
        System.out.println(communities);
    }
    
    
    
    @Test
    public void insertSelect() {
        Community community = new Community();
        community.setCommunityId(1);
        community.setCategoryId(1);
        community.setCommunityDescription("这是第一个社区");
        community.setCommunityName("官方社区1");
        community.setCreatedBy(1);
        
        int result = communityMapper.insert(community);
        System.out.println(result);
        System.out.println(community);
    }
    
    @Test
    public void selectById(){
        Community community = communityMapper.selectById(2);
        System.out.println(community);
    }
    
    
    @Test
    public void deleteById(){
        communityMapper.deleteById(2);
    }
    
    
    
    
    
}
