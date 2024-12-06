package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateUserCourseCountDTO {
    
    private Date clickDate;
    private String courseName;
    private Integer courseNum;
    
}
