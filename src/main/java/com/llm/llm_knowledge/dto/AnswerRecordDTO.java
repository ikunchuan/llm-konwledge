package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRecordDTO {
    private Integer userId;
    private Integer questionId; //外键
    private String answerGiven;

    //查询字段
    private String questionTitle;
    private String questionText;
    private Integer questionLevel;
    private Integer minScore;
    private Integer maxScore;
}
