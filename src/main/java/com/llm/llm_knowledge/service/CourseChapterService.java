package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.CourseChapter;

import java.util.List;

public interface CourseChapterService {

    //全部查询
    List<CourseChapter> getCourseChapter();

   //条件查询
   List<CourseChapter> getCourseChapterByCourseId(Integer id);
}
