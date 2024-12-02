package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("question")
public class Question {
    //自增字段
    @TableId(type = IdType.AUTO)
    private Integer questionId;

    private Integer categoryId;
    private String questionTitle;
    private String questionText;
    private String correctAnswer;
    private String reMark;

    //自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    //自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

//  @TableLogic(value = "0",delval = "1") //逻辑删除，默认是0，删除的值为1
//    private Integer deleted;
}
