package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course_lesson")
public class CourseLesson {
    
    @TableId(type = IdType.AUTO)
    private Integer lessonId;
    
    private Integer courseId;
    private Integer chapterId;
    private String lessonName;
    
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
