package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Category;

public interface CategoryService {
    Integer addCategory(Category category);
    Integer deleteCategoryById(Integer id);
    Integer updateCategoryById(Category category);
    Category findCategoryById(Integer id);
    Page<Category> allPageCategory(Integer pageNum, Integer pageSize);
}
