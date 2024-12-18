package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course_comment")
public class CourseComment {
    
    @TableId(type= IdType.AUTO)
    private Integer commentId;
    private Integer userId;
    private String commentContent;
    private Integer courseId;
    private Integer courseLikes;
    private Integer is_active;
    //自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    
    //自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
}
