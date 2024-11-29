package com.llm.llm_knowledge.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Competition {
    @TableId(type = IdType.AUTO)
    private Integer competitionId;
    private String competitionName;
    private Integer categoryId;
    private Integer levelId;
    private String competitionImgUrl;
    private String competitionStatus;
    private Integer isActive;
    private Date createdTime;
    private Date updatedTime;

}
