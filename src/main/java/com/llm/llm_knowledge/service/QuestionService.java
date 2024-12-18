package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.QuestionDTO;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.vo.QuestionSearch;

import java.util.List;

public interface QuestionService {
    //插入题目
    Integer insertQuestion(Question question);

    //根据id删除
    Integer deleteQuestionById(Integer id);

    //根据id批量删除
    Integer deleteQuestionByIds(List<Integer> ids);

    //条件删除
    Integer criteriaDeleteQuestion(Question question);

    //更新题目
    Integer updateQuestionById(Question question);

    //根据id查询
    Question findQuestionById(Integer id);

    //根据id批量查询
    List<Question> findQuestionByIds(List<Question> ids);

    //条件查询
    List<Question> criteriaFindQuestion(Integer id);

    //分页查询全部记录
    Page<Question> findAllPageQuestion(Integer pageNum, Integer pageSize);

    //根据题目的种类标签输入的内容来模糊查询
    PageInfo<QuestionDTO> search(QuestionSearch questionSearch, Integer pageNum, Integer pageSize);

    //查全
    List<Question> allQuestion();
    
    List<Question> getQstByParentId(Integer parentId);
}
