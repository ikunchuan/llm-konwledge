package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostCountDTO {
    
    private Integer userId;
    private String userName;
    private Integer postCount;
    private String userEmail;
    private String userBio;
    private String userLocal;
    private Integer userAge;
    
}
