package com.llm.llm_knowledge.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    
    private Integer courseId;
    private String courseDescription;
    private String courseName;
    private String courseRating;
    private String courseDuration;
    private String createdTime;
    private String updatedTime;
    private String courseDifficultyLevel;
    private String categoryName;

}
