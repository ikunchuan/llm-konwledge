package com.llm.llm_knowledge.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String communityName;
    private String userName;
    private String createdTime;
    private String updatedTime;
    
    
}