package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseComment;
import com.llm.llm_knowledge.vo.CourseChapterSearch;
import com.llm.llm_knowledge.vo.CourseSearch;

import java.util.List;

public interface CourseService {
    //查询所有
    List<Course>allCourse();

    //插入课程
    Integer insertCourse(Course course);

    //根据id删除课程
    Integer deleteCourseById(Integer id);

    //根据id批量删除
    Integer deleteCourseByIds(List<Integer> ids);

    //更新课程
    Integer updateCourseById(Course course);

    //根据id查询
    Course findCourseById(Integer id);

    //分页查询全部记录
    Page<Course> findAllPageCourse(Integer pageNum, Integer pageSize);
    
    PageInfo<CourseDTO> search(CourseSearch courseSearch, Integer pageNum, Integer pageSize);

    List<Course> searchParagraph(String courseName);
    
    List<CourseChapterDTO> searchChapter(CourseChapterSearch courseChapterSearch);

    // CourseService.java
    List<CourseChapterDTO> getAllChapters();
    
    Integer addCourseView(Integer userId, Integer courseId);
    
    List<Course> getCourseByParentId(Integer parentId);
    
    List<CourseComment> getCourseComment(Integer courseId);
}
