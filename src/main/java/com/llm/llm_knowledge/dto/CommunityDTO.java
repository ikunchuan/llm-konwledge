package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDTO {
    
    private Integer communityId;
    private String communityName;
    private String communityDescription;
    private String userName;
    private String categoryName;
    private String createdTime;
    private String updatedTime;
    
}
