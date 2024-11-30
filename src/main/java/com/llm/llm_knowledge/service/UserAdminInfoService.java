package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;

public interface UserAdminInfoService {

    /**
     * 登录
     * @param userAdminInfo
     * @return
     */
    UserAdminInfo login(UserAdminInfo userAdminInfo) throws UserException;


    /**
     * 注册用户
     * @param userAdminInfo
     * @return
     * @throws UserException
     */
    Integer register(UserAdminInfo userAdminInfo) throws UserException;

}
