package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import com.llm.llm_knowledge.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    //插入题目
    @Override
    public Integer insertQuestion(Question question) {
        int result = questionMapper.insert(question);//会自动插入ID
        System.out.println(result);
        System.out.println(question);
        return result;
    }

    //根据id删除
    @Override
    public Integer deleteQuestionById(Question question) {
        Integer i = questionMapper.deleteById(question);
        System.out.println(i);
        return i;
    }

    //根据id批量删除
    @Override
    public Integer deleteQuestionByIds(List<Question> ids) {
        List<Integer> ids_ = new ArrayList<>();
        for (Question question : ids) {
            Integer questionId = question.getQuestionId();
            ids_.add(questionId);
        }
        Integer i = questionMapper.deleteByIds(ids_);
        System.out.println(i);
        return i;
    }

    //条件删除
    @Override
    public Integer criteriaDeleteQuestion(Question question) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("question_title", question.getQuestionTitle());
        queryWrapper.eq("category", question.getCategoryId());
        Integer i = questionMapper.delete(queryWrapper);
        System.out.println(i);
        return i;
    }

    //更新题目
    @Override
    public Integer updateQuestionById(Question question) {
        Integer i = questionMapper.updateById(question);
        System.out.println(i);
        return i;
    }

    //根据id查询
    @Override
    public Question findQuestionById(Integer id) {
        return questionMapper.selectById(id);
    }

    //根据id批量查询
    @Override
    public List<Question> findQuestionByIds(List<Question> ids) {
        List<Integer> ids_ = new ArrayList<>();
        for (Question question : ids) {
            Integer questionId = question.getQuestionId();
            ids_.add(questionId);
        }
        return questionMapper.selectByIds(ids_);
    }

    //条件查询
    @Override
    public List<Question> criteriaFindQuestion(Question question) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("question_title", question.getQuestionTitle());
        queryWrapper.eq("question_id", question.getQuestionId());
        queryWrapper.eq("question_id", question.getQuestionId());
        return questionMapper.selectList(queryWrapper);
    }

    //分页查询全部记录
    @Override
    public Page<Question> findAllPageQuestion(Question question) {
        return new Page<>(1, 5);
    }
}
