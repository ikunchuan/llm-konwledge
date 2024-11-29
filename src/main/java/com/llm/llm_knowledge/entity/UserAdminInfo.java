package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;


@Data
@TableName("user_admin_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminInfo {

    private Integer userId;

    private String userName;

    private String password;

    //字段添加填充内容
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updatedTime;

}
