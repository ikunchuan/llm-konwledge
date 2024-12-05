package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseProgressDTO {
    
    private String userName;
    private Integer userId;
    private Integer isCompleted;
    
}
