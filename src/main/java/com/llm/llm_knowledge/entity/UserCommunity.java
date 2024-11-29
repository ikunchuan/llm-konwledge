package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("community_join")
public class UserCommunity {
    @TableId(type = IdType.AUTO)
    Integer communityJoinId;
    Integer userId;
    Integer communityId;
    @TableField(fill= FieldFill.INSERT)
    Date createdTime;
}
