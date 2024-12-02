package com.llm.llm_knowledge.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author : symao
 */
@Data
public class UserAdminInfoVO {

    private Integer userId;

    private String userName;

    private String password;

    private Date createdTime;

    private Date updatedTime;

}
