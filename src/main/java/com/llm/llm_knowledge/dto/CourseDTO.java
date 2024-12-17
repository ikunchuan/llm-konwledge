package com.llm.llm_knowledge.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    
    private String courseImgUrl;
    private Integer courseId;
    private String courseDescription;
    private String courseName;
    private String courseRating;
    private String courseDuration;
    private Date createdTime;
    private Date updatedTime;
    private String courseDifficultyLevel;
    private String categoryName;
    private String bvid;

}
