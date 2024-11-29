package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("community")
public class Community {
    
    @TableId(type = IdType.AUTO)
    Integer communityId;
    Integer categoryId;
    String communityName;
    String CommunityDescription;
    Integer createdBy;
    
   @TableField(fill= FieldFill.INSERT)
    Date createdTime;
    
}
