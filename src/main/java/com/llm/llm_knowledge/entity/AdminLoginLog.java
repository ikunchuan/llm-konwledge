package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin_login_log")
public class AdminLoginLog {
    
    @TableId(type = IdType.AUTO)
    private Integer adminLoginLogId;
    
    private String userName;
    
    private String password;
    private Integer loginboard;
    
    @TableField(fill= FieldFill.INSERT)
    private Date loginTime;
    

}
