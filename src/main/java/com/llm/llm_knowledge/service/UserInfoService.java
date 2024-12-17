package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.*;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.vo.UserInfoSearch;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

    // 获取用户性别分布
    List<Map<String, Object>> getUserSexDistribution();
    //获取用户总数
    public int getUserTotalCount();
    // 查询所有用户（分页）
    IPage<UserInfo> allUser(Integer pageNum, Integer pageSize);


    //根据cmnid查询社区
    public UserInfo userInfoById(Integer userid);

    //增加社区
    public Integer addUserInfo(UserInfo userInfo);

    //删除社区
    public Integer delUserInfo(Integer userid);

    //更新社区
    public Integer updateUserInfo(UserInfo userInfo);

    //模糊查询用户 这里是未被冻结的用户
    PageInfo<UserInfo> uiByCondi(UserInfoSearch userInfoSearch, Integer pageNum, Integer pageSize);
    
    //模糊查询用户 这里是被冻结的用户
    PageInfo<UserInfo> uiByCondi2(UserInfoSearch userInfoSearch, Integer pageNum, Integer pageSize);
    
    
    List<UserCourseProgressDTO> progressDTO();

    //获取用户观看视频总数
    List<Map<String, Object>> getCompletedCoursesCount();
    
    
    List<UserCityDTO> getCityUserCount();
    
    List<UserAgeDTO> getAgeUserCount();
    
    List<DateUserCourseCountDTO> selectDateCourseAll();
    
    
    //普通用户登录
    UserInfo login(UserInfo userInfo) throws UserException;
    
    //普通用户注册
    Integer register(UserInfo userInfo) throws UserException;
    
    List<UserInfo> lookFollower(Integer userId);
    
    List<UserInfo> lookFans(Integer userId);
    
    List<UserScoreDTO> getScore(Integer userId, Integer communityId);

    Integer userFollow(Integer userId, Integer followeeUserId);
}

