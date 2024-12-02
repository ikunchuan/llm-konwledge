package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("crs/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //插入
    @PostMapping("v1")
    public Integer insertCourse(@RequestBody Course course){
        return courseService.insertCourse(course);
    }

    //id删除
    @DeleteMapping("v1/{id}")
    public Integer deleteCourseById(@PathVariable Integer id){
        return courseService.deleteCourseById(id);
    }

    //更新
    @PutMapping("v1")
    public Integer updateCourseById(@RequestBody Course course){
        return courseService.updateCourseById(course);
    }

    //id查询
    @GetMapping("v1/{id}")
    public Course findCourseById(@PathVariable Integer id){
        return courseService.findCourseById(id);
    }

    //分页查全
    @GetMapping("v1")
    public Page<Course> findAllPageCourse(Integer pageNum, Integer pageSize){
        return courseService.findAllPageCourse(pageNum,pageSize);
    }
}
