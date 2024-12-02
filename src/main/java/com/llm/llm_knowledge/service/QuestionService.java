package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;

import java.util.List;

public interface QuestionService {
    //插入题目
    Integer insertQuestion(Question question);

    //根据id删除
    Integer deleteQuestionById(Question question);

    //根据id批量删除
    Integer deleteQuestionByIds(List<Question> ids);

    //条件删除
    Integer criteriaDeleteQuestion(Question question);

    //更新题目
    Integer updateQuestionById(Question question);

    //根据id查询
    Question findQuestionById(Integer id);

    //根据id批量查询
    List<Question> findQuestionByIds(List<Question> ids);

    //条件查询
    List<Question> criteriaFindQuestion(Question question);

    //分页查询全部记录
    Page<Question> findAllPageQuestion(Question question);
}
