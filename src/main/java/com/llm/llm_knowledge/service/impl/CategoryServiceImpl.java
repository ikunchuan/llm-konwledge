package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.mapper.CategoryMapper;
import com.llm.llm_knowledge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //分页查询
    @Override
    public Page<Category> allPageCategory(Integer pageNum, Integer pageSize) {
        Page<Category> categoryPage = new Page<>(pageNum, pageSize);
        Page<Category> categoryPageVar = categoryMapper.selectPage(categoryPage, null);
        categoryPageVar.getRecords().forEach(System.out::println);
        return categoryPageVar;
    }
}
