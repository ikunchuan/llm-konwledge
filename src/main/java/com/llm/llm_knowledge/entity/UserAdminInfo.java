package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;


@Data
@TableName("user_admin_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminInfo {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String password;
    
    private Integer userAdminAge;
    private String userAdminPhone;
    private String userAdminEmail;
    private Date userAdminBirthday;
    private Integer userAdminSex;
    private String userAdminLocal;

    //字段添加填充内容
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;

}
