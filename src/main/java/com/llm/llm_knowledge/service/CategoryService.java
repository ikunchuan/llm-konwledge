package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CategoryDTO;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.vo.CategorySearch;

import java.util.List;

public interface CategoryService {

//    // 获取所有父类（parentId == 0）
//    List<Category> getParentCategories();
//
//    // 根据父类 ID 获取对应的子类
//    List<Category> getSubCategoriesByParentId(Integer parentId);

    Integer addCategory(Category category);

    Integer deleteCategoryById(Integer id);

    Integer deleteCategoryByIds(List<Integer> ids);

    Integer updateCategoryById(Category category);

    Category findCategoryById(Integer id);

    PageInfo<CategoryDTO> search(CategorySearch categorySearch, Integer pageNum, Integer pageSize);

    List<Category> allIdAndName();

    List<Category> getSubCategoriesByParentId(Integer categoryId);

    List<Category> getAllSubCategories();

    List<Category> getQstCat();
}
