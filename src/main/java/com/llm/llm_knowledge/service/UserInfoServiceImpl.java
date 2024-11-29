package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
    @Override
    public Page<UserInfo> findAllPageUserInfo(UserInfo userInfo) {
        return null;
    }

    @Override
    public Integer updateUserInfoById(UserInfo userInfo) {
        return 0;
    }

    @Override
    public List<UserInfo> findUserInfoById(UserInfo userInfo) {
        return List.of();
    }

    @Override
    public List<UserInfo> findUserInfoByIds(List<UserInfo> ids) {
        return List.of();
    }

    @Override
    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo) {
        return List.of();
    }
}
