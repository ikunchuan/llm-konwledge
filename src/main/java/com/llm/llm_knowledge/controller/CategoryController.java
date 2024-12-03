package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("cat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

//    // 获取所有父类类别
//    @GetMapping("/parent")
//    public List<Category> getParentCategories() {
//        return categoryService.getParentCategories();  // 返回所有 parent_id 为 null 或 0 的类别
//    }
//    // 获取指定父类的子类
//    @GetMapping("/subs/{parentId}")
//    public List<Category> getSubCategoriesByParentId(@PathVariable Integer parentId) {
//        return categoryService.getSubCategoriesByParentId(parentId);  // 返回指定 parentId 的所有子类
//    }


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

    //分页查全
    @GetMapping("v1/page")
    public Page<Category> allPageCategory(Integer pageNum,Integer pageSize){
        return categoryService.allPageCategory(pageNum,pageSize);
    }
}
