package com.llm.llm_knowledge.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseChapter;
import com.llm.llm_knowledge.entity.CourseContent;
import com.llm.llm_knowledge.entity.CourseLesson;
import com.llm.llm_knowledge.mapper.CourseChapterMapper;
import com.llm.llm_knowledge.mapper.CourseLessonMapper;
import com.llm.llm_knowledge.service.CourseChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseChapterServiceImpl implements CourseChapterService {
    @Autowired
    private CourseChapterMapper courseChapterMapper;
    
    @Autowired
    private CourseLessonMapper courseLessonMapper;
    
    //查询全部
    @Override
    public List<CourseChapter>getCourseChapter(){return courseChapterMapper.selectList(null);}
    //条件查询
    @Override
    public List<CourseChapter> getCourseChapterByCourseId(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("course_id", id);
        return courseChapterMapper.selectList(queryWrapper);
    }
    
    @Override
    public Integer insertCourseChapter(CourseChapter courseChapter) {
        return courseChapterMapper.insert(courseChapter);
    }
    
    @Override
    public Integer updateCourseChapter(CourseChapter courseChapter) {
        return courseChapterMapper.updateById(courseChapter);
    }
    
    @Override
    public Integer deleteCourseChapter(Integer id) {
        return courseChapterMapper.deleteById(id);
    }
    
    @Override
    public List<CourseLesson> getLessonWithChapter(Integer chapterId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("chapter_id",chapterId);
        return courseLessonMapper.selectList(queryWrapper);
    }
    
    @Override
    public Integer addChapterLesson(CourseLesson courseLesson) {
        return courseLessonMapper.insert(courseLesson);
    }
    
    @Override
    public Integer updateChapterLesson(CourseLesson courseLesson) {
        return courseLessonMapper.updateById(courseLesson);
    }
    
    @Override
    public Integer deleteChapterLesson(Integer lessonId) {
        return courseLessonMapper.deleteById(lessonId);
    }
}
