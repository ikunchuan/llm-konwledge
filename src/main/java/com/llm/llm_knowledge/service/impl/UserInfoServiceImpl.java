package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Community;
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

    //查询所有用户
    @Override
    public IPage<UserInfo> allUser(Integer pageNum, Integer pageSize) {
        Page<UserInfo> page = new Page<>(pageNum,pageSize);
        return userInfoMapper.selectPage(page,null);
    }

    //更新用户
    @Override
    public Integer updateUserInfoById(UserInfo userInfo) {
        return userInfoMapper.updateById(userInfo);
    }

//    //根据id查询
//    @Override
//    public UserInfo findUserInfoById(Integer userId) {return userInfoMapper.selectById(userId);}

//    //条件查询
//    @Override
//    public List<UserInfo> criteriaFindUserInfo(UserInfo userInfo) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like("user_name", userInfo.getUserName());
//        queryWrapper.eq("user_id", userInfo.getUserId());
//        return userInfoMapper.selectList(queryWrapper);
//    }


    //分页查询全部记录
    @Override
    public IPage<UserInfo> uiByUserid(Integer userId, String userName, Integer pageNum, Integer pageSize) {


        // 创建查询条件
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();

        // 根据 userId 和 userName 条件进行查询
        if (userId != null) {
            wrapper.eq("user_id", userId);  // 假设 userId 是 UserInfo 表中的字段
        }
        if (userName != null && !userName.isEmpty()) {
            wrapper.like("user_name", userName);  // 假设 userName 是 UserInfo 表中的字段
        }

        // 创建分页对象
        Page<UserInfo> page = new Page<>(pageNum, pageSize);
        Page<UserInfo> userPageVar = userInfoMapper.selectPage(page, null);

        // 执行分页查询
        return userPageVar;
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
