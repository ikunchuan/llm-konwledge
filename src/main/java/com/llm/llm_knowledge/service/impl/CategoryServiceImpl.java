package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CategoryDTO;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.mapper.CategoryMapper;
import com.llm.llm_knowledge.service.CategoryService;
import com.llm.llm_knowledge.vo.CategorySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    //添加
    @Override
    public Integer addCategory(Category category) {
        int result = categoryMapper.insert(category);//会自动插入ID
        System.out.println(result);
        System.out.println(category);
        return result;
    }

    //删除
    @Override
    public Integer deleteCategoryById(Integer id) {
        Integer i = categoryMapper.deleteById(id);
        System.out.println(i);
        return i;
    }

    //批量删除
    @Override
    public Integer deleteCategoryByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        // 调用 Mapper 层进行批量删除
        int result = categoryMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
    }

    //更新
    @Override
    public Integer updateCategoryById(Category category) {
        Integer i = categoryMapper.updateById(category);
        System.out.println(i);
        return i;
    }

    //查询id
    @Override
    public Category findCategoryById(Integer id) {
        return categoryMapper.selectById(id);
    }

    //父类别分页查询
    @Override
    public PageInfo<CategoryDTO> search(CategorySearch categorySearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CategoryDTO> category = categoryMapper.selectCategoryWithFilters(categorySearch);
        return new PageInfo<>(category);
    }

    //条件查询id和name
    @Override
    public List<Category> allIdAndName() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("category_id", "parent_id", "category_name");
        return categoryMapper.selectList(queryWrapper);
    }

    @Override
    public List<Category> getSubCategoriesByParentId(Integer categoryId) {
        return categoryMapper.getSubCategoriesByParentId(categoryId);
    }

    @Override
    public List<Category> getAllSubCategories() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("parent_id");
        return categoryMapper.selectList(queryWrapper);
    }

    @Override
    public List<Category> getQstCat() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("category_id", "category_name");
        queryWrapper.in("category_name", Arrays.asList(
                "程序设计", "网络安全", "人工智能与大数据",
                "数据挖掘与分析", "数学知识", "数学建模",
                "语言表达", "英语应用", "跨文化交流"));
        return categoryMapper.selectList(queryWrapper);
    }
}
