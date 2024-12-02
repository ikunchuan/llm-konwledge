package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.CategoryMapper;
import com.llm.llm_knowledge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Integer addCategory(Category category) {
        int result = categoryMapper.insert(category);//会自动插入ID
        System.out.println(result);
        System.out.println(category);
        return result;
    }

    @Override
    public Integer deleteCategoryById(Integer id) {
        Integer i = categoryMapper.deleteById(id);
        System.out.println(i);
        return i;
    }

    @Override
    public List<Category> updateCategory() {
        return List.of();
    }

    @Override
    public Question findQuestionById(Integer id) {
        return null;
    }

    @Override
    public Page<Category> allPageCategory(Integer pageNum, Integer pageSize) {
        return null;
    }
}
