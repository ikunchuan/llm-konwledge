package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "course", autoResultMap = true) // 确保表名正确
public class Course {

    @TableId(type= IdType.AUTO)
    private int courseId; // 课程唯一标识（主键）
    private String courseName; // 课程名称
    private int categoryId; // 类别ID，关联课程类别表（外键）
    private String courseDescription; // 课程简介
    private String courseImgUrl; // 课程封面图片链接
    private Integer courseDuration; // 预计学习时长（小时）
    private String courseDifficultyLevel; // 难度级别（初级、中级、高级）
    private BigDecimal courseRating; // 用户评分（范围 0-5）
    private double coursePrice;//价格
    private Integer popular;   //热门课程推荐
    private String bvid;       //课程的bvid 原来播放b站视频

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime; // 记录创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime; // 记录最后更新时间
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> knowledgeNetwork;
    @TableField(exist = false) // 表示非数据库字段
    private Double matchScore;

}
