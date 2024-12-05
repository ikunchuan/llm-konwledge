package com.llm.llm_knowledge.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@TableName("admin_login_log")
public class AdminLoginLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminLoginLogId;
    
    private String userName;
    
    private String password;
    
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime loginTime;
    

}
