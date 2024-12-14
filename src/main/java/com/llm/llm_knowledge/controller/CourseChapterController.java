package com.llm.llm_knowledge.controller;


import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseChapter;
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
    
    
}
