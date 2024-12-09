package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("post_comment")
public class PostComment {
    
    @TableId(type = IdType.AUTO)
    private Integer commentId;
    private Integer userId;
    private Integer postId;
    private String commentContent;
    
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
    
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;

}
