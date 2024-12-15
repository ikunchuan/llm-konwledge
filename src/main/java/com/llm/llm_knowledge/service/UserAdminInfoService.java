package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.entity.AdminLoginLog;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.vo.LoginLogSearch;
import com.llm.llm_knowledge.vo.UserAdminInfoVO;

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
    
    
    void recordLoginLog(UserAdminInfoVO userAdminInfoVO);
    
    PageInfo<AdminLoginLog> getAdminLoginLog(LoginLogSearch loginLogSearch,Integer pageNum,Integer pageSize);
}
