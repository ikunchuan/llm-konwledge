package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_info", autoResultMap = true)
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Integer userId;//用户id
    private String userName;//用户
    private String userSex;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userProfilePicture;
    private String userBio;
    private String userLocal;
    private Integer userUnderview;//用户id
    private Integer userAge;//用户id
    //字段添加填充内容
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    // UserInfo.java
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> knowledgeNetwork;
    @TableField(exist = false) // 表示非数据库字段
    private Integer matchScore;

}
