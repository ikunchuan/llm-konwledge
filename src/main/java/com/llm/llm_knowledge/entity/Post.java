package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("post")
public class Post {
    
    @TableId(type = IdType.AUTO)
    Integer postId;

    Integer communityId;
    Integer userId;
    String postTitle;
    String postContent;
    
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
}
