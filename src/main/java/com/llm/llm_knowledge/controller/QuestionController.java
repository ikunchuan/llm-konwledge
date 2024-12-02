package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("qst")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //插入
    @PostMapping("v1")
    public Integer insertQuestion(@RequestBody Question question) {
        return questionService.insertQuestion(question);
    }

    //id删除
    @DeleteMapping("v1/{id}")
    public Integer deleteQuestionById(@PathVariable Integer id) {
        return questionService.deleteQuestionById(id);
    }

    //批量删除
    @DeleteMapping("v1")
    public Integer deleteQuestionByIds(@RequestBody List<Integer> ids){
        System.out.println("Received IDs: " + ids);
        return questionService.deleteQuestionByIds(ids);
    }

    //更新
    @PutMapping("v1")
    public Integer updateQuestionById(@RequestBody Question question) {
        return questionService.updateQuestionById(question);
    }

    //id查询
    @GetMapping("v1/{id}")
    public Question findQuestionById(@PathVariable Integer id) {
        return questionService.findQuestionById(id);
    }

    //分页查全
    @GetMapping("v1/page")
    public Page<Question> findAllPageQuestion(Integer pageNum, Integer pageSize) {
        return questionService.findAllPageQuestion(pageNum, pageSize);
    }
}
