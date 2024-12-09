package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompFavoriteDTO {
    private Integer competitionFavoriteId;
    private Integer competitionId;
    private Integer userId;
    private String competitionName;
}
