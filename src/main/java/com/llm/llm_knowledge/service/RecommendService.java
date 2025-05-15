package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.Competition;

import java.util.List;

public interface RecommendService {
    List<Course> recommendCoursesByKnowledge(Integer userId);
    List<Competition> recommendCompetitionsByKnowledge(Integer userId);
}