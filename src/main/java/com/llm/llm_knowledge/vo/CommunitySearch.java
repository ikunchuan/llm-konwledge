package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunitySearch {
    
    private String communityName;
    private String communityDescription;
    private String userName;
    private String categoryName;
    private Integer popular;
    
}
