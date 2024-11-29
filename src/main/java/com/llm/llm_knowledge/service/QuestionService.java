package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface QuestionService {
//    分页查询
    Page<Question> findAllPageQuestion();
//
//    List<Question> findAllQuestionById();


    //更新题目
    Integer updateQuestionById();


    List<Question> findAllQuestion();
}
