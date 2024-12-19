package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseViewVO {
    private Integer courseViewId;
    private Integer courseId;
    private String courseName;
    private String courseImgUrl;
    private String courseDescription;
    private String updatedTime;
}
