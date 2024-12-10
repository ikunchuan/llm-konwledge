package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseView {
    
    @TableId(type = IdType.AUTO)
    private Integer courseViewId;
    
    private Integer viewCount;
    private Integer userId;
    private Integer courseId;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
    private Integer deleted;
    
}
