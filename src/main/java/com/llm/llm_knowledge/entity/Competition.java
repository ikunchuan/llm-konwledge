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
    private Integer levelId;
    private String competitionImgUrl;
    private String competitionStatus;
    private Integer isActive;
    //自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    //自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;


}
