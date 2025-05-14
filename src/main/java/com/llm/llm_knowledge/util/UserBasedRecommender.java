package com.llm.llm_knowledge.util;

import java.util.*;
import java.util.stream.Collectors;

public class UserBasedRecommender {

    private final Map<Integer, Set<Integer>> userItemMap;

    public UserBasedRecommender(Map<Integer, Set<Integer>> userItemMap) {
        this.userItemMap = userItemMap;
    }

    public List<Integer> recommend(int targetUserId, int topN) {
        Set<Integer> targetItems = userItemMap.getOrDefault(targetUserId, new HashSet<>());
        Map<Integer, Double> similarityScores = new HashMap<>();

        SimilarityCalculator calculator = new SimilarityCalculator();

        // 计算与其他用户的相似度
        for (Map.Entry<Integer, Set<Integer>> entry : userItemMap.entrySet()) {
            int otherUserId = entry.getKey();
            if (otherUserId == targetUserId) continue;

            double similarity = calculator.computeSimilarity(targetItems, entry.getValue());
            similarityScores.put(otherUserId, similarity);
        }

        // 根据相似用户的收藏推荐
        Map<Integer, Double> recommendationScores = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : similarityScores.entrySet()) {
            int otherUserId = entry.getKey();
            double similarity = entry.getValue();
            Set<Integer> otherItems = userItemMap.get(otherUserId);

            for (Integer itemId : otherItems) {
                if (!targetItems.contains(itemId)) {
                    recommendationScores.merge(itemId, similarity, Double::sum);
                }
            }
        }

        return recommendationScores.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
