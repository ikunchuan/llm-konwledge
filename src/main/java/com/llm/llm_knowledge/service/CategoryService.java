package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Category;

import java.util.List;

public interface CategoryService {

    // 获取所有父类（parentId == 0）
    List<Category> getParentCategories();

    // 根据父类 ID 获取对应的子类
    List<Category> getSubCategoriesByParentId(Integer parentId);

    Integer addCategory(Category category);
    Integer deleteCategoryById(Integer id);
    Integer deleteCategoryByIds(List<Integer> ids);
    Integer updateCategoryById(Category category);
    Category findCategoryById(Integer id);
    Page<Category> allPageCategory(Integer pageNum, Integer pageSize);
}
