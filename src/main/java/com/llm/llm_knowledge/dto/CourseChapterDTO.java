package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseChapterDTO {
    
    private String chapterName;
    private String courseName;
    private String createdTime;
    private String updatedTime;
    
}
