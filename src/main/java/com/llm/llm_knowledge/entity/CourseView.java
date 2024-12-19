package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
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

    private Integer userId;
    private Integer courseId;
    private Integer viewCount;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

}
