package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_community_score")
public class UserCommunityScore {
    
    @TableId(type = IdType.AUTO)
    private Integer userCommunityScore;
    
    private Integer userId;
    private Integer communityId;
    private Integer score;
    
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
}
