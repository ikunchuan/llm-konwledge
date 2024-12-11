package com.llm.llm_knowledge.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author : symao
 */
@Data
public class UserLoginInfoVO {

    private Integer userId;

    private String userName;

    private String userPassword;

    private Date createdTime;

    private Date updatedTime;


}
