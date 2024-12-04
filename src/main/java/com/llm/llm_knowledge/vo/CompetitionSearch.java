package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionSearch {

    private Integer categoryId;
    private Integer levelId;
    private String competitionName;
    private Integer isActive;

}
