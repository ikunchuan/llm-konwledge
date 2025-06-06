package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.CourseDTO;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseComment;
import com.llm.llm_knowledge.vo.CourseChapterSearch;
import com.llm.llm_knowledge.vo.CourseSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> selectTopMatches(@Param("keywords") String keywordsJson);
    
    List<CourseDTO> selectCoursesWithFilters(CourseSearch courseSearch);
    
    List<CourseChapterDTO> selectChaptersWithFilters(CourseChapterSearch courseChapterSearch);

   //查询所有章节信息（我还不会写，没搞完）
    List<CourseChapterDTO> selectAllChapters();
    
    Integer addCourseView(Integer userId, Integer courseId);
    
    List<Integer> getChildByParent(Integer parentId);
    
    List<Course> getCourByIds(Integer integer);
    
    List<CourseComment> getCourseComment(Integer courseId);
}
