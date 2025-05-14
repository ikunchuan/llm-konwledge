package com.llm.llm_knowledge.util;

import com.llm.llm_knowledge.entity.CompetitionFavorite;

import java.util.*;

public class UserCompetitionMatrixBuilder {

    public Map<Integer, Set<Integer>> build(List<CompetitionFavorite> favorites) {
        // user_id -> set of competition_id
        Map<Integer, Set<Integer>> matrix = new HashMap<>();
        for (CompetitionFavorite fav : favorites) {
            matrix.computeIfAbsent(fav.getUserId(), k -> new HashSet<>()).add(fav.getCompetitionId());
        }
        return matrix;
    }
}
