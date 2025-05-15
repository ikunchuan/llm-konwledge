package com.llm.llm_knowledge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompFavoriteDTO {
    private Integer competitionFavoriteId;
    private Integer competitionId;
    private String competitionName;
    private String competitionImgUrl;
    private Date updatedTime;
}
