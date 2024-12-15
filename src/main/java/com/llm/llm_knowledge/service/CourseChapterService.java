package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseChapter;
import com.llm.llm_knowledge.entity.CourseContent;
import com.llm.llm_knowledge.entity.CourseLesson;

import java.util.List;

public interface CourseChapterService {
    
    //全部查询
    List<CourseChapter> getCourseChapter();
    
    //条件查询
    List<CourseChapter> getCourseChapterByCourseId(Integer id);
    
    Integer insertCourseChapter(CourseChapter courseChapter);
    
    Integer updateCourseChapter(CourseChapter courseChapter);
    
    Integer deleteCourseChapter(Integer id);
    
    List<CourseLesson> getLessonWithChapter(Integer chapterId);
    
    Integer addChapterLesson(CourseLesson courseLesson);
    
    Integer updateChapterLesson(CourseLesson courseLesson);
    
    Integer deleteChapterLesson(Integer lessonId);
}
