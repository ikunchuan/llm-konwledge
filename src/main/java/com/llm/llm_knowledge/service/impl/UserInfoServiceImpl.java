package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.mapper.UserInfoMapper;
import com.llm.llm_knowledge.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    //更新用户
    @Override
    public Integer updateUserInfoById(UserInfo userInfo) {
        int i = userInfoMapper.updateById(userInfo);//会自动插入ID
        System.out.println(i);
        return i;
    }

//    //根据id查询
//    @Override
//    public UserInfo findUserInfoById(Integer userId) {return userInfoMapper.selectById(userId);}

    //条件查询
    @Override
    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("user_name", userInfo.getUserName());
        queryWrapper.eq("user_id", userInfo.getUserId());
        return userInfoMapper.selectList(queryWrapper);
    }

    //分页查询全部记录
    @Override
    public Page<UserInfo> findAllPageUserInfo(Integer pageNum, Integer pageSize) {
        return new Page<>(pageNum, pageSize);
    }


//    //根据id批量查询
//    @Override
//    public List<UserInfo> findUserInfoByIds(List<UserInfo> ids) {
//        List<Integer> ids_ = new ArrayList<>();
//        for (UserInfo userInfo : ids) {
//            Integer questionId = userInfo.getUserId();
//            ids_.add(questionId);
//        }
//        return userInfoMapper.selectByIds(ids_);

//    //条件查询
//    @Override
//    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like("question_title", userInfo.getQuestionTitle());
//        queryWrapper.eq("question_id", userInfo.getQuestionId());
//        queryWrapper.eq("question_id", userInfo.getQuestionId());
//        return questionMapper.selectList(queryWrapper);
//    }



}
