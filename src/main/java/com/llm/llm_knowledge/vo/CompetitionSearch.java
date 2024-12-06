package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionSearch {

    private Integer categoryId;
    private String categoryName;
    private String competitionName;
    private String isActive;

}
