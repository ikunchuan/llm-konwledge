package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserAdminInfoService {

    /**
     * 查询用户信息
     * @param userAdminInfo
     * @return
     */
    UserAdminInfo findUserAdminInfo(UserAdminInfo userAdminInfo) throws UserException;

    /**
     * 插入用户信息
     * @param userAdminInfo
     * @return
     */
    Integer addUserAdminInfo(UserAdminInfo userAdminInfo);

}
