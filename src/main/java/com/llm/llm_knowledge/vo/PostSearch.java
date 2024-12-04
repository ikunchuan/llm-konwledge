package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSearch {
    
    private String communityName;
    private String userName;
    private String postTitle;
    private String postContent;
    
}

