package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
    private Integer deleted;
    
}
