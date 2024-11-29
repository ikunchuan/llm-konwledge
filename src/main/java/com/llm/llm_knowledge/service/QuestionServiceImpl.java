package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionMapper questionMapper;

    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public Page<Question> findAllPageQuestion() {
        return null;
    }

    @Override
    public Integer updateQuestionById() {
        return null;
    }

    @Override
    public List<Question> findAllQuestion() {
        return questionMapper.selectList(null);
    }

}
