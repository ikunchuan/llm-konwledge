package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Course;

public interface CourseService {
    //插入课程
    Integer insertCourse(Course course);

    //根据id删除课程
    Integer deleteCourseById(Integer id);

    //更新课程
    Integer updateCourseById(Course course);

    //根据id查询
    Course findCourseById(Integer id);

    //分页查询全部记录
    Page<Course> findAllPageCourse(Integer pageNum, Integer pageSize);
}
