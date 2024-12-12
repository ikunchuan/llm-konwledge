package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserScoreDTO {
    
    private String userName;
    private Integer userId;
    private Integer score;
    
}
