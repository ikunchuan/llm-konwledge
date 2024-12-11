package com.llm.llm_knowledge.dto;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDTO {
    private Integer competitionId;
    private String competitionName;
    private String categoryName;
    private String levelName;
    private String competitionImgUrl;
    private String competitionStatus;
    private String isActive;
    private Date createdTime;
    private Date updatedTime;
    private Date startDate;
    private Date endDate;

}
