package com.llm.llm_knowledge.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String communityName;
    private String userName;
    private Date createdTime;
    private Date updatedTime;
    private Integer likeCount;
    private Integer favoriteCount;
    private Integer commentCount;
    
    
}
