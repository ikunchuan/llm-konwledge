package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.dto.CourseChapterDTO;
import com.llm.llm_knowledge.dto.UserCourseProgressDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.mapper.UserInfoMapper;
import com.llm.llm_knowledge.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    //获取男女人数
    @Override
    public List<Map<String, Object>>getUserSexDistribution() {
        return userInfoMapper.findUserSexDistribution();
    }
    //获取用户总数
    @Override
    public int getUserTotalCount() {
        return userInfoMapper.getUserTotalCount();
    }


    // 查询所有用户
    @Override
    public IPage<UserInfo> allUser(Integer pageNum, Integer pageSize) {
        Page<UserInfo> page = new Page<>(pageNum, pageSize);
        return userInfoMapper.selectPage(page, null);
    }
    //根据id查询
    @Override
    public UserInfo userInfoById(Integer userid) {
        return userInfoMapper.selectById(userid);
    }

    //增加用户
    @Override
    public Integer addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    //根据id删除用户
    @Override
    public Integer delUserInfo(Integer userid) {
        return userInfoMapper.deleteById(userid);
    }
    //更新社区用户信息
    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateById(userInfo);
    }


    // 根据 userId 和 userName 分页查询用户
    @Override
    public IPage<UserInfo> uiByCondi(Integer userSex, String userName, Integer pageNum, Integer pageSize) {
        // 创建查询条件
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_underview",1);
        // 根据 userId 和 userName 条件进行查询
        if (userSex != null) {
            wrapper.eq("user_id", userSex);  // 假设 userId 是 UserInfo 表中的字段
        }
        if (userName != null && !userName.isEmpty()) {
            wrapper.like("user_name", userName);  // 假设 userName 是 UserInfo 表中的字段
        }

        // 创建分页对象
        Page<UserInfo> page = new Page<>(pageNum, pageSize);

        // 执行分页查询
        return userInfoMapper.selectPage(page, wrapper);
    }
    
    @Override
    public List<UserCourseProgressDTO> progressDTO() {
        List<UserCourseProgressDTO> userCourseProgressDTOS = userInfoMapper.selectProgressWithFilters();
        return userCourseProgressDTOS;
    }
    
    //获取用户观看视频总数
    @Override
    public List<Map<String, Object>> getCompletedCoursesCount() {
        List<Map<String, Object>> result = userInfoMapper.countCompletedCoursesByUser();
        return result;
        
    }
    
    @Override
    public IPage<UserInfo> uiByCondi2(Integer userSex, String userName, Integer pageNum, Integer pageSize) {
        // 创建查询条件
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_underview",0);
        
        // 创建分页对象
        Page<UserInfo> page = new Page<>(pageNum, pageSize);
        
        // 执行分页查询
        return userInfoMapper.selectPage(page, wrapper);
    }
    
    
}






