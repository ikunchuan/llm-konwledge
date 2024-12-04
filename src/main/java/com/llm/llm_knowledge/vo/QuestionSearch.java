package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSearch {
    private String questionTitle;
    private  String questionText;
    private Integer questionLevel;
    private Integer categoryName;
}
