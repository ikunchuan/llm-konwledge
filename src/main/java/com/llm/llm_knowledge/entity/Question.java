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
public class Question {
    @TableId( type = IdType.AUTO)
    private Integer questionId;
    private Integer categoryId;
    private  String questionTitle;
    private String questionText;
    private  String correctAnswer;

    @TableField(fill = FieldFill.INSERT)
   private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
   private Date updatedTime;
}
