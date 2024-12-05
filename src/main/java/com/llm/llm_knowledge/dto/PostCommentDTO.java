package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentDTO {
    
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String commentContent;
    private String userName;
    private Date createdTime;
    private Date updatedTime;
    
}
