package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.UserInfo;

import java.util.List;

public interface UserInfoService {


    //分页查询全部记录
    Page<UserInfo> findAllPageUserInfo(UserInfo userInfo);

    //更新用户
    Integer updateUserInfoById(UserInfo userInfo);

    //根据id查询
    List<UserInfo> findUserInfoById(UserInfo userInfo);

    //根据id批量查询
    List<UserInfo> findUserInfoByIds(List<UserInfo> ids);

    //条件查询
    List<UserInfo> criteriaFindUserInfo(UserInfo userInfo);
}
