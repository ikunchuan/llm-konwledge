package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.*;
import com.llm.llm_knowledge.entity.*;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.mapper.UserInfoMapper;
import com.llm.llm_knowledge.service.UserInfoService;
import com.llm.llm_knowledge.vo.UserInfoSearch;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
    public PageInfo<UserInfo> uiByCondi(@RequestBody UserInfoSearch userInfoSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> userInfos = userInfoMapper.selectUserInfoAll(userInfoSearch);
        
        return new PageInfo<>(userInfos);
    }
    
    
    //这里查找的是被冻结的用户
    @Override
    public PageInfo<UserInfo> uiByCondi2(@RequestBody UserInfoSearch userInfoSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> userInfos = userInfoMapper.selectUserInfoAll2(userInfoSearch);
        
        return new PageInfo<>(userInfos);
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
    public List<UserCityDTO> getCityUserCount() {
        return userInfoMapper.getCityUserCount();
    }
    
    @Override
    public List<UserAgeDTO> getAgeUserCount() {
        return userInfoMapper.getAgeUserCount();
    }
    
    @Override
    public List<DateUserCourseCountDTO> selectDateCourseAll() {
        return userInfoMapper.selectDateCourseAll();
    }
    
    
    //查看关注者
    @Override
    public List<UserInfo> lookFollower(Integer userId) {
        return userInfoMapper.lookFollower(userId);
    }
    
    
    //查看粉丝
    @Override
    public List<UserInfo> lookFans(Integer userId) {
        return userInfoMapper.lookFans(userId);
    }
    
    
    //查看某个用户的某个社区的积分
    @Override
    public List<UserScoreDTO> getScore(Integer userId, Integer communityId) {
        return userInfoMapper.getScore(userId,communityId);
    }

    @Override
    public Integer userFollow(Integer userId, Integer followeeUserId) {
        return userInfoMapper.userFollow(userId,followeeUserId);
    }
    
    //查看课程浏览记录
    @Override
    public List<Course> getCourseView(Integer userId) {
        return userInfoMapper.getCourseView(userId);
    }
    
    @Override
    public List<Post> getPostView(Integer userId) {
        return userInfoMapper.getPostView(userId);
    }
    
    
    @Override
    public UserInfo login(UserInfo userInfo) throws UserException {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userInfo.getUserName());
        String md5 = DigestUtils.md5Hex(userInfo.getUserPassword());
        queryWrapper.eq("user_password", md5);
        UserInfo userInfoFromDB = userInfoMapper.selectOne(queryWrapper);
        // 如果用户名或密码错误，抛出异常
        if (null == userInfoFromDB) {
            throw new UserException("用户名或密码错误");
        }
        return userInfoFromDB;
    }
    
    @Override
    public Integer register(UserInfo userInfo) throws UserException {
        // 判断用户名是否存在
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userInfo.getUserName());
        Long count = userInfoMapper.selectCount(queryWrapper);
        // 这里同时考虑了两种情况：1.存在一个用户 2.或者存在多个用户
        if (1 <= count) {
            throw new UserException("用户已存在");
        }
        //对用户的密码进行加密
        String md5 = DigestUtils.md5Hex(userInfo.getUserPassword());
        //把用户名和密码放到创建userAdminInfo里面
        userInfo.setUserPassword(md5);
        //调用userAdminInfoService里面的方法
        return userInfoMapper.insert(userInfo);
    }
    

    
    
}






