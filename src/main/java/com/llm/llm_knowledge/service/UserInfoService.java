package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    //查询所有社区
    public IPage<UserInfo> allUser(Integer pageNum, Integer pageSize);

    //更新用户
    Integer updateUserInfoById(UserInfo userInfo);

//    //根据id查询
//    UserInfo findUserInfoById(Integer userId);

//    //根据id批量查询
//    List<UserInfo> findUserInfoByIds(List<UserInfo> ids);

//    //条件查询
//    List<UserInfo> criteriaFindUserInfo(UserInfo userInfo);

    //分页查询全部记录
    IPage<UserInfo> uiByUserid(Integer userId, String userName, Integer  pageNum, Integer pageSize);
}
