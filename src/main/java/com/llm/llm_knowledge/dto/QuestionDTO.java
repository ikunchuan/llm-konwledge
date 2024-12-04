package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Integer questionId;
    private String questionTitle;
    private String questionText;
    private Integer questionLevel;
    private String categoryName;
    private Date createdTime;
    private Date updatedTime;
}
