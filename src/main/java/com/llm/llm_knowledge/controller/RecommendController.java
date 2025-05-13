package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> recommendByUserId(@RequestParam Long userId) {
        List<Course> recommendations = recommendService.recommendCoursesByUserId(userId);
        return ResponseEntity.ok(recommendations);
    }
}
