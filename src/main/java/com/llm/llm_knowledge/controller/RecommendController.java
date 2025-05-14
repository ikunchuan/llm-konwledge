package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.service.RecommendService;
import com.llm.llm_knowledge.service.impl.RecommendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private RecommendServiceImpl recommendServiceImpl;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> recommendByUserId(@RequestParam Long userId) {
        List<Course> recommendations = recommendService.recommendCoursesByUserId(userId);
        return ResponseEntity.ok(recommendations);
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


