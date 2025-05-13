package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Course;

import java.util.List;

public interface RecommendService {
    // 根据用户ID推荐课程
    List<Course> recommendCoursesByUserId(Long userId);
}
