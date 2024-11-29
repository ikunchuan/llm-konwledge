package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    //分页查询全部记录
    @Override
    public Page<UserInfo> findAllPageUserInfo(UserInfo userInfo) {
        return null;
    }

    //更新用户
    @Override
    public Integer updateUserInfoById(UserInfo userInfo) {
        int result = userInfoMapper.updateById(userInfo);//会自动插入ID
        System.out.println(result);
        System.out.println(userInfo);
        return result;
    }

    //根据id查询
    @Override
    public List<UserInfo> findUserInfoById(Integer userId) {
        UserInfo i = userInfoMapper.selectById(userId);
        System.out.println(i);
        return null;
    }

    //根据id批量查询
    @Override
    public List<UserInfo> findUserInfoByIds(List<UserInfo> ids) {
        return List.of();
    }

    //条件查询
    @Override
    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo) {
        return List.of();
    }
}
