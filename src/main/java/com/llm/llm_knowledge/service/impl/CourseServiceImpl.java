package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Course;

import com.llm.llm_knowledge.mapper.CourseMapper;
import com.llm.llm_knowledge.service.CourseService;
import com.llm.llm_knowledge.vo.CourseChapterSearch;
import com.llm.llm_knowledge.vo.CourseSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override  //插入课程
    public Integer insertCourse(Course course) {
        int result = courseMapper.insert(course);
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


    @Override    //根据id批量删除
    public Integer deleteCourseByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        // 可以选择添加对 ids 内容的进一步验证
        if (ids.stream().anyMatch(id -> id == null || id <= 0)) {
            // 如果存在无效的 ID，返回 0 或者抛出异常
            throw new IllegalArgumentException("无效的课程ID");
        }
        // 调用 Mapper 层进行批量删除
        int result = courseMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
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
        // 创建分页对象
        Page<Course> coursePage = new Page<>(pageNum, pageSize);
        // 通过 courseMapper 获取分页数据
        Page<Course> coursePageVar = courseMapper.selectPage(coursePage, null);
        // 可以将分页的记录打印出来，但要注意在生产环境中最好使用日志框架（如 logback）
        coursePageVar.getRecords().forEach(System.out::println);
        // 返回分页结果
        return coursePageVar;
    }

    @Override
    public PageInfo<CourseDTO> search(@RequestBody CourseSearch courseSearch, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CourseDTO> courseDTOS = courseMapper.selectCoursesWithFilters(courseSearch);
        return new PageInfo<>(courseDTOS);
    }

    @Override
    public List<Course> searchParagraph(String courseName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("course_name", courseName);
        return courseMapper.selectList(queryWrapper);
    }
    
    @Override
    public List<CourseChapterDTO> searchChapter(CourseChapterSearch courseChapterSearch) {
        return courseMapper.selectChaptersWithFilters(courseChapterSearch);
    }
    



}
