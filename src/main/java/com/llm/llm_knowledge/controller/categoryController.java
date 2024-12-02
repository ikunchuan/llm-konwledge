package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.service.CategoryService;
import com.llm.llm_knowledge.service.QuestionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.MXBean;

@RestController
@CrossOrigin
@RequestMapping("cat")
public class categoryController {
    @Autowired
    private CategoryService categoryService;

    //插入
    @PostMapping("v1")
    public Integer addCategory(Category category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping("v1")

}
