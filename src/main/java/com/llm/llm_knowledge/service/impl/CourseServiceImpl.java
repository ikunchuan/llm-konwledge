package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.mapper.CourseMapper;
import com.llm.llm_knowledge.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override  //插入课程
    public Integer insertCourse(Course course) {
        Integer result = courseMapper.insert(course);
        System.out.println(result);
        System.out.println(course);
        return result;
    }


    @Override    //根据id删除
    public Integer deleteCourseById(Integer id) {
        Integer i = courseMapper.deleteById(id);
        System.out.println(i);
        return i;
    }

    @Override //更新课程
    public Integer updateCourseById(Course course) {
        Integer i = courseMapper.updateById(course);
        System.out.println(i);
        return i;
    }

    @Override   //根据id查询
    public Course findCourseById(Integer id) {
        return courseMapper.selectById(id);
    }


    @Override   //分页查询全部记录
    public Page<Course> findAllPageCourse(Integer pageNum, Integer pageSize) {
        Page<Course> coursePage = new Page<>(pageNum, pageSize);
        Page<Course> coursePageVar = courseMapper.selectPage(coursePage, null);
        coursePageVar.getRecords().forEach(System.out::println);
        return coursePageVar;
    }



}
