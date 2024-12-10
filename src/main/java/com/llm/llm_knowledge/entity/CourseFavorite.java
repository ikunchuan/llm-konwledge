package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFavorite {

    @TableId(type = IdType.AUTO)
    private Integer courseFavoriteId;

    private Integer courseId;
    private Integer userId;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
