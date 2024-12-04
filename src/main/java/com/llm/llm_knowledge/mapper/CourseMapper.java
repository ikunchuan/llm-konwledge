package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.vo.CourseSearch;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {
    
    List<CourseDTO> selectCoursesWithFilters(CourseSearch courseSearch);
    
}
