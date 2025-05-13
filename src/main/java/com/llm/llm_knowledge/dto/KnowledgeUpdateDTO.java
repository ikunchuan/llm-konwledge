package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeUpdateDTO {
    private Integer userId;
    private List<String> knowledge;
}
