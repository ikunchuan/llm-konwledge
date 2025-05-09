package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseComment;
import com.llm.llm_knowledge.service.CourseService;
import com.llm.llm_knowledge.util.FileUtil;
import com.llm.llm_knowledge.vo.CourseChapterSearch;
import com.llm.llm_knowledge.vo.CourseSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("crs")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //查询所有
    @GetMapping("v1")
    public List<Course> allCourse() {
        return courseService.allCourse();
    }

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
    @PostMapping("search")
    public PageInfo<CourseDTO> search(@RequestBody CourseSearch courseSearch,
                                      @RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "5") Integer pageSize){
        return courseService.search(courseSearch,pageNum,pageSize);
    }
    
    //查询某个课程的章节
    @PostMapping("search/chapter")
    public List<CourseChapterDTO> searchChapter(@RequestBody CourseChapterSearch courseChapterSearch){
        return courseService.searchChapter(courseChapterSearch);
    }
    
    //根据课程的名字查询课程所有数据
    @GetMapping("searchParagraph/{courseName}")
    public List<Course> searchParagraph(@PathVariable String courseName){
        return courseService.searchParagraph(courseName);
    }
    
    //显示章节表里所有信息
    @GetMapping("allChapters")
    public List<CourseChapterDTO> getAllChapters() {
        return courseService.getAllChapters();
    }
    
    //课程浏览记录 用户浏览一个课程 传入用户Id和课程Id 增加一条记录
    @GetMapping("course/view")
    public Integer addCourseView(@RequestParam Integer userId,
                                 @RequestParam Integer courseId){
        return courseService.addCourseView(userId,courseId);
    }

    //图片上传
    @PostMapping ("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String oldFileName = file.getOriginalFilename();  // 获取原始文件名
        System.out.println(oldFileName);
        String typeName = oldFileName.substring(oldFileName.lastIndexOf('.'));  // 获取文件扩展名
        String filePath = FileUtil.getUpLoadFilePath();  // 获取文件保存路径
        System.out.println(typeName);
        String newFileName = System.currentTimeMillis() + oldFileName;  // 生成新文件名，防止覆盖
        
        try {
            // 保存文件到指定路径
            FileUtil.uploadFile(file.getBytes(), filePath, newFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);  // 如果上传失败，抛出运行时异常
        }
        
        return newFileName;  // 返回新文件名
    }
    
    
    //传来一个category_id,这个Id可能是父id也可能是子id
    @GetMapping("course/byParentId")
    public List<Course> getCourseByParentId(@RequestParam Integer parentId){
        return courseService.getCourseByParentId(parentId);
    }
    

    //传来一个course_id,查看这个课程的所有评论
    @GetMapping("course/comment/{courseId}")
    public List<CourseComment> getCourseComment(@PathVariable Integer courseId){
        return  courseService.getCourseComment(courseId);
        
    }
    
    

}
