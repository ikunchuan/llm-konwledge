package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostView {

    @TableId(type = IdType.AUTO)
    private Integer postViewId;

    private Integer postId;
    private Integer userId;
    private Integer viewCount;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
}
