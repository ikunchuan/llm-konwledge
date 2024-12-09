package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("community")
public class Community {
    
    @TableId(type = IdType.AUTO)
    private Integer communityId;
    private Integer categoryId;
    private String communityName;
    private String CommunityDescription;
    private Integer createdBy;
    
    private Integer communityUnderview;
    
    private String communityImageUrl;
    
   @TableField(fill= FieldFill.INSERT)
   private Date createdTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
   private Date updatedTime;
    
}
