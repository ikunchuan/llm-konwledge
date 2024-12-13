package com.llm.llm_knowledge.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llm.llm_knowledge.entity.CourseChapter;
import com.llm.llm_knowledge.mapper.CourseChapterMapper;
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
}
