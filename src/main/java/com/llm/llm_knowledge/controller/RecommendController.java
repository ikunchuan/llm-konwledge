package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.service.RecommendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    private final RecommendService recommendService;

    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @GetMapping("/courses")
    public List<Course> recommendCourses(@RequestParam Integer userId) {
        return recommendService.recommendCoursesByKnowledge(userId);
    }

    @GetMapping("/competitions")
    public List<Competition> recommendCompetitions(@RequestParam Integer userId) {
        return recommendService.recommendCompetitionsByKnowledge(userId);
    }
}