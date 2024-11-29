package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        int i = questionMapper.deleteByIds(ids_);
        System.out.println(i);
        return i;
    }

    //条件删除
    @Override
    public Integer criteriaDeleteQuestion(Question question) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("question_title","两数之和1");
        questionMapper.deleteByMap(map);
        return null;
    }

    //更新题目
    @Override
    public Integer updateQuestionById(Question question) {
        return null;
    }

    //根据id查询
    @Override
    public List<Question> findQuestionById(Question question) {
        return null;
    }

    //根据id批量查询
    @Override
    public List<Question> findQuestionByIds(List<Question> ids) {
        List<Integer> ids_ = new ArrayList<>();
        for (Question question : ids) {
            Integer questionId = question.getQuestionId();
            ids_.add(questionId);
        }
        List<Question> questions = questionMapper.selectByIds(ids_);
        questions.
        return i;
        return null;
    }

    //条件查询
    @Override
    public List<Question> criteriaFindQuestion(Question question) {
        return null;
    }

    //分页查询全部记录
    @Override
    public Page<Question> findAllPageQuestion(Question question) {
        return null;
    }
}
