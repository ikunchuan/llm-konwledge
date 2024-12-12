package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSearch {

    private String courseName;
    private String courseDescription;
    private String courseDifficultyLevel;
    private String courseRating;
    private Integer popular;

}
