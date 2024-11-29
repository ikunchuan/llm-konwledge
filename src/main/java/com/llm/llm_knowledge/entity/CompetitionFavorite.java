package com.llm.llm_knowledge.entity;

import lombok.Data;

import java.util.Date;

public class CompetitionFavorite {
    private Integer competitionFavoriteId;
    private Integer competitionId;
    private Integer userId;
    private Date favoritedAt;
}
