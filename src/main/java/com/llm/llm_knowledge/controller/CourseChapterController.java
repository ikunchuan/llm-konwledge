package com.llm.llm_knowledge.controller;


import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseChapter;
import com.llm.llm_knowledge.entity.CourseContent;
import com.llm.llm_knowledge.entity.CourseLesson;
import com.llm.llm_knowledge.service.CourseChapterService;
import com.llm.llm_knowledge.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("chap")
public class CourseChapterController {
    @Autowired
    private CourseChapterService courseChapterService;
    
    //查询全部
    @GetMapping("v1")
    public List<CourseChapter> getAllCourseChapter() {
        return courseChapterService.getCourseChapter();
    }
    
    @GetMapping("v1/{id}")
    public List<CourseChapter> getCourseChapter(@PathVariable Integer id) {
        return courseChapterService.getCourseChapterByCourseId(id);
        
    }
    
    //上传章节
    @PostMapping("v1")
    public Integer insertCourseChapter(@RequestBody CourseChapter courseChapter){
        return courseChapterService.insertCourseChapter(courseChapter);
    }

    //更改章节
    @PutMapping("v1")
    public Integer updateCourseChapter(@RequestBody CourseChapter courseChapter){
        return courseChapterService.updateCourseChapter(courseChapter);
    }
    
    //删除章节
    @DeleteMapping("v1/{id}")
    public Integer deleteCourseChapter(@PathVariable Integer id){
        return courseChapterService.deleteCourseChapter(id);
    }
    
    //传入章节的Id,可以查询这个章节的所有课程选集
    @GetMapping("v1/chapterlesson/{chapterId}")
    public List<CourseLesson> getLessonWithChapter(@PathVariable Integer chapterId){
        return courseChapterService.getLessonWithChapter(chapterId);
    }
    
    
    //对具体lesson的操作,放到章节的Controller里面
    //上传lesson
    @PostMapping("v1/chapterlesson")
    public Integer addChapterLesson(@RequestBody CourseLesson courseLesson){
        return courseChapterService.addChapterLesson(courseLesson);
    }
    
    //更新lesson
    @PutMapping("v1/chapterlesson")
    public Integer updateChapterLesson(@RequestBody CourseLesson courseLesson){
        return courseChapterService.updateChapterLesson(courseLesson);
    }
    
    //删除lesson
    @DeleteMapping("v1/chapterlesson/{lessonId}")
    public Integer deleteChapterLesson(@PathVariable Integer lessonId){
        return courseChapterService.deleteChapterLesson(lessonId);
    }
    
}
