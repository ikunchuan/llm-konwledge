package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("answer_record")
public class AnswerRecord {

    @TableId(type = IdType.AUTO)
    private Integer answerRecordId;

    private Integer userId;
    private Integer questionId;

    private String answerGiven;
    private Integer score;
    private Integer timeSpent;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
