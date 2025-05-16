package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFavoriteDTO {
    private Integer postFavoriteId;
    private Integer postId;
    private String postTitle;
    private String postContent;
    private Date updatedTime;
}
