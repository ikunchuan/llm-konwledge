package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionSearch {

    private Integer categoryId;
    private String categoryName;
    private String competitionName;
    private String isActive;
    private Integer popular;
    
    private String levelName;
    private String competitionStatus;
    
    private Date startDate;
    private Date endDate;

}
