package com.llm.llm_knowledge.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseViewVO {
    private Integer courseViewId;//用户浏览课程记录id
    private Integer courseId;
    private String courseName;
    private String courseImgUrl;
    private String courseDescription;
    private String updatedTime;//用户浏览更新的时间
}
