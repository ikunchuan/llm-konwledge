package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.service.CourseService;
import com.llm.llm_knowledge.vo.CourseChapterSearch;
import com.llm.llm_knowledge.vo.CourseSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("crs")
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

    //批量删除
    @DeleteMapping("v1")
    public Integer deleteCourseById(@RequestBody List<Integer> ids){
        System.out.println("Received IDs: " + ids);
//        List<Integer> idList = Arrays.stream(ids.split(","))
//                .map(Integer::parseInt) // 将字符串转换为 Integer
//                .collect(Collectors.toList());
        return courseService.deleteCourseByIds(ids);
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
    @GetMapping("v1/page")
    public Page<Course> findAllPageCourse(Integer pageNum, Integer pageSize){
        return courseService.findAllPageCourse(pageNum,pageSize);
    }
    
    //多表联查
    @PostMapping("/search")
    public PageInfo<CourseDTO> search(@RequestBody CourseSearch courseSearch,
                                      @RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize){
        return courseService.search(courseSearch,pageNum,pageSize);
    }
    
    //查询某个课程的章节
    @PostMapping("/search/chapter")
    public List<CourseChapterDTO> searchChapter(@RequestBody CourseChapterSearch courseChapterSearch){
        return courseService.searchChapter(courseChapterSearch);
    }
    
    //



}
