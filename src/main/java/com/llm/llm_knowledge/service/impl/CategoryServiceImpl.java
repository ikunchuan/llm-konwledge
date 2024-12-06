package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

//    @Override
//    public List<Category> getParentCategories() {
//        return categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_id", 0));
//    }
//
//    @Override
//    public List<Category> getSubCategoriesByParentId(Integer parentId) {
//        return categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_id", parentId));
//    }

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

    //分页查询
    @Override
    public Page<Category> allPageCategory(Integer pageNum, Integer pageSize) {
        Page<Category> categoryPage = new Page<>(pageNum, pageSize);
        Page<Category> categoryPageVar = categoryMapper.selectPage(categoryPage, null);
        categoryPageVar.getRecords().forEach(System.out::println);
        return categoryPageVar;
    }

    @Override
    public PageInfo<CategoryDTO> search(CategorySearch categorySearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CategoryDTO> categoryDTOS = categoryMapper.selectCategoryWithFilters(categorySearch);
        return new PageInfo<>(categoryDTOS);
    }

    //条件查询id和name
    @Override
    public List<Category> allIdAndName() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("category_id","parent_id","category_name");
        return categoryMapper.selectList(queryWrapper);
    }

    //查全
    @Override
    public List<Category> allCategory() {
        return categoryMapper.selectList(null);
    }

    @Override
    public List<Category> getSubCategoriesByParentId(Integer parentId) {
        return categoryMapper.getSubCategoriesByParentId(parentId);
    }


}
