package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.service.RecommendService;
import com.llm.llm_knowledge.service.impl.RecommendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @Autowired
    private RecommendServiceImpl recommendServiceImpl;

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
    @Autowired
    private CompetitionMapper competitionMapper;

    //协同过滤
    @GetMapping("/{userId}")
    public List<Competition> recommend(@PathVariable Integer userId) {
        List<Integer> recommendedIds = recommendServiceImpl.recommendForUser(userId);
        return competitionMapper.selectBatchIds(recommendedIds);
    }
}