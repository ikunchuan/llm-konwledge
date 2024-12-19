package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostViewVO {
    private Integer postViewId;//用户浏览帖子的id
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String communityId;
    private String updatedTime;//用户浏览更新的时间
}
