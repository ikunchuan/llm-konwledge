package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFavoriteDTO {
    private Integer courseFavoriteId;
    private Integer courseId;
    private String courseName;
    private String courseDifficultyLevel;
}
