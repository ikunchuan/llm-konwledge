package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.QuestionDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.QuestionService;
import com.llm.llm_knowledge.vo.QuestionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //查询类别中题目
    @GetMapping("v1/cate/{id}")
    public List<Question> criteriaFindQuestion(@PathVariable Integer id) {
        return questionService.criteriaFindQuestion(id);
    }

    //分页查全
    @GetMapping("v1/page")
    public Page<Question> findAllPageQuestion(Integer pageNum, Integer pageSize) {
        return questionService.findAllPageQuestion(pageNum, pageSize);
    }

    //模糊联表查询
    @PostMapping("v1/search")
    public PageInfo<QuestionDTO> search(
            @RequestBody QuestionSearch questionSearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return questionService.search(questionSearch, pageNum, pageSize);
    }

    @GetMapping("v1/all")
    public List<Question> allQuestion() {
        return questionService.allQuestion();
    }

    
    //传来一个category_id, 通过这个id找到所有的Question
    @GetMapping("v1/qstByParentId")
    public List<Question> getQstByParentId(@RequestParam Integer parentId){
        return questionService.getQstByParentId(parentId);
    }
    
    
    
    
}
