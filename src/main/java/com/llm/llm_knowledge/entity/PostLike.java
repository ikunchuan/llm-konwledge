package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLike {
    
    @TableId(type = IdType.AUTO)
    private Integer postLikeId;
    
    private Integer postId;
    private Integer userId;
    private String isLiked;

    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    
}
