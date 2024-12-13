package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course_chapter")
public class CourseChapter {
    private Integer chapterId;
    private String chapterName;
    private Integer courseId;
    private String chapterDescription;
    //自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    //自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
