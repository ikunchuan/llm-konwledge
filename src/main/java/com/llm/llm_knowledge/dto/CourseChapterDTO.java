package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseChapterDTO {
    
    private String chapterName;
    private String courseName;
    private Date createdTime;
    private Date updatedTime;
    
}
