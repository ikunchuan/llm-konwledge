package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDTO {
    
    private Integer communityId;
    private String communityName;
    private String communityDescription;
    private String userName;
    private String categoryName;
    private Integer communityUnderview;
    private String communityImageUrl;
    private Date createdTime;
    private Date updatedTime;
    
}
