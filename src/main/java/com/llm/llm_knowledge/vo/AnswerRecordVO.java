package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRecordVO {
    private Integer answerRecordId;
    private Integer userId;
    private Integer questionId;
    private String answerGiven;
    private Integer score;
    private Integer timeSpent;

    // 外键关联的返回字段
    private String questionTitle;
    private String questionText;
    private String correctAnswer;
    private Integer questionLevel;
}
