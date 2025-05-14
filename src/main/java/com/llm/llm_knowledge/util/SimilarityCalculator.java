package com.llm.llm_knowledge.util;

import java.util.HashSet;
import java.util.Set;

public class SimilarityCalculator {

    public double computeSimilarity(Set<Integer> a, Set<Integer> b) {
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        if (a.size() == 0 || b.size() == 0) return 0.0;

        double numerator = intersection.size();
        double denominator = Math.sqrt(a.size()) * Math.sqrt(b.size());

        return numerator / denominator;
    }
}
