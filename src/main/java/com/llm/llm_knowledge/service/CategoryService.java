package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.entity.Question;

import java.util.List;

public interface CategoryService {
    Integer addCategory(Category category);
    Integer deleteCategoryById(Integer id);
    List<Category> updateCategory();
    Question findQuestionById(Integer id);
    Page<Category> allPageCategory(Integer pageNum, Integer pageSize);
}
