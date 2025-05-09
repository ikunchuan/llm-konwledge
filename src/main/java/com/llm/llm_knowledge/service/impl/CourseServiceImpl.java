package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseComment;
import com.llm.llm_knowledge.mapper.CourseMapper;
import com.llm.llm_knowledge.service.CourseService;
import com.llm.llm_knowledge.vo.CourseChapterSearch;
import com.llm.llm_knowledge.vo.CourseSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    //查询所有
    @Override
    public List<Course>allCourse() {return courseMapper.selectList(null);}

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

    
    //查询课程 总的 可以在这里面加很多条件
    @Override
    public PageInfo<CourseDTO> search(CourseSearch courseSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
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

    @Override
    public List<CourseChapterDTO> getAllChapters() {
        return courseMapper.selectAllChapters(); // 调用 Mapper 层方法
    }

    //课程观看记录
    @Override
    public Integer addCourseView(Integer userId, Integer courseId) {
        return courseMapper.addCourseView(userId, courseId);
    }
    
    @Override
    public List<Course> getCourseByParentId(Integer parentId) {
        //listCour 用来返回查到的数据
        List<Course> listCour = new ArrayList<>();
        
        //先查到传来的id的所有子id
        List<Integer> childCategoryIds = courseMapper.getChildByParent(parentId);
        
        //如果没有childCategoryIds,则它不是父id
        if (childCategoryIds == null || childCategoryIds.isEmpty()) {
            List<Course> courByIds = courseMapper.getCourByIds(parentId);
            listCour.addAll(courByIds);
        } else {
            //然后根据所有的子id来查找这些竞赛 把竞赛放到compeByIds里面 然后listComp拼接compeByIds
            for (int i = 0; i < childCategoryIds.size(); i++) {
                List<Course> courByIds = courseMapper.getCourByIds(childCategoryIds.get(i));
                listCour.addAll(courByIds);
            }
        }
        
        return listCour;
    }
    
    @Override
    public List<CourseComment> getCourseComment(Integer courseId) {
        return courseMapper.getCourseComment(courseId);
    }
    
}
