package com.llm.llm_knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CategoryDTO;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.CategoryService;
import com.llm.llm_knowledge.vo.CategorySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("cat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //插入
    @PostMapping("v1")
    public Integer addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    //删除
    @DeleteMapping("v1/{id}")
    public Integer deleteCategoryById(@PathVariable Integer id){
        return categoryService.deleteCategoryById(id);
    }

    //批量删除
    @DeleteMapping("v1")
    public Integer deleteQuestionByIds(@RequestBody List<Integer> ids){
        System.out.println("Received IDs: " + ids);
        return categoryService.deleteCategoryByIds(ids);
    }

    //更新
    @PutMapping("v1")
    public Integer updateCategoryById(@RequestBody Category category){
        return categoryService.updateCategoryById(category);
    }

    //查询
    @GetMapping("v1/{id}")
    public Category findCategoryById(@PathVariable Integer id){
        return categoryService.findCategoryById(id);
    }

    //查询id和name
    @GetMapping("v1/all")
    public List<Category> allIdAndName(){
        return categoryService.allIdAndName();
    }

    //条件查询
    @PostMapping("v1/search")
    public PageInfo<CategoryDTO> search(
            @RequestBody CategorySearch categorySearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return categoryService.search(categorySearch, pageNum, pageSize);
    }

    @GetMapping("v1/subcategories/{categoryId}")
    public List<Category> getSubCategoriesByParentId(@PathVariable Integer categoryId) {
        return categoryService.getSubCategoriesByParentId(categoryId);
    }

}
