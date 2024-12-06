package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer categoryId;
    private String categoryName;
    private String description;
    private Integer parentId;
    private Date createdTime;
    private Date updatedTime;
}
