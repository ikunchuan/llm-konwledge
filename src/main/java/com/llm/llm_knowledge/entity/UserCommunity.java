package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("community_join")
public class UserCommunity {
    @TableId(type = IdType.AUTO)
    private Integer communityJoinId;
    private Integer userId;
    private Integer communityId;
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
}
