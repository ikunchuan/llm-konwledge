package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Integer userId;//用户id
    private String userName;//用户
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userProfilePicture;
    private String userBio;
    //字段添加填充内容
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
