package com.llm.llm_knowledge.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("competition")
public class Competition {

    @TableId(type = IdType.AUTO)

    private Integer competitionId;
    private String competitionName;
    private Integer categoryId;
    private String levelName;
    private String competitionImgUrl;
    private String competitionStatus;
    private String isActive;
    private Integer popular;
    //自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    //自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;


}
