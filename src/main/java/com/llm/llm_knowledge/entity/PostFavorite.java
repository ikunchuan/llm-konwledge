package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("post_favorite")
public class PostFavorite {
    
    @TableId(type = IdType.AUTO)
    private Integer postFavoriteId;
    
    private Integer userId;
    private Integer postId;
    
    @TableField(fill= FieldFill.INSERT)
    private Date updatedTime;
    
    private Integer deleted;
    
}
