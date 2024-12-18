package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.QuestionDTO;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import com.llm.llm_knowledge.service.QuestionService;
import com.llm.llm_knowledge.vo.QuestionSearch;
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
    public Integer deleteQuestionById(Integer id) {
        Integer i = questionMapper.deleteById(id);
        System.out.println(i);
        return i;
    }

    //根据id批量删除
    @Override
    public Integer deleteQuestionByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        // 调用 Mapper 层进行批量删除
        int result = questionMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
    }

    //条件删除
    @Override
    public Integer criteriaDeleteQuestion(Question question) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("question_id", question.getQuestionId());
        queryWrapper.eq("category_id", question.getCategoryId());
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
    public List<Question> criteriaFindQuestion(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id", id);
        return questionMapper.selectList(queryWrapper);
    }

    //分页查询全部记录
    @Override
    public Page<Question> findAllPageQuestion(Integer pageNum, Integer pageSize) {
        Page<Question> questionPage = new Page<>(pageNum, pageSize);
        Page<Question> questionPageVar = questionMapper.selectPage(questionPage, null);
        questionPageVar.getRecords().forEach(System.out::println);
        return questionPageVar;
    }

    //根据题目的种类标签输入的内容来模糊查询
    @Override
    public PageInfo<QuestionDTO> search(QuestionSearch questionSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionDTO> questionDTOS = questionMapper.selectQuestionsWithFilters(questionSearch);
        return new PageInfo<>(questionDTOS);
    }

    //查全
    @Override
    public List<Question> allQuestion() {
        return questionMapper.selectList(null);
    }
    
    @Override
    public List<Question> getQstByParentId(Integer parentId) {
        
        List<Question> listQst = new ArrayList<>();
        
        List<Integer> childCategoryIds = questionMapper.getChildByParent(parentId);
        
        if(childCategoryIds == null || childCategoryIds.isEmpty()){
            List<Question> qstByIds = questionMapper.getQstByIds(parentId);
            listQst.addAll(qstByIds);
        }else {
            for(Integer childId : childCategoryIds){
                List<Question> qstByIds = questionMapper.getQstByIds(childId);
                listQst.addAll(qstByIds);
            }
        }
        
        return listQst;
    }
}
