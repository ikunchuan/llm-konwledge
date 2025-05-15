package com.llm.llm_knowledge.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "competition", autoResultMap = true)
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
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> knowledgeNetwork;
    // Competition.java
    @TableField(exist = false)
    private Double matchScore;

}
