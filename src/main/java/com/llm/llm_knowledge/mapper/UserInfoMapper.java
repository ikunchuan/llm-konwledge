package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.*;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.vo.UserInfoSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    // 新增获取用户分布数据的方法
    List<Map<String, Object>> findUserSexDistribution();

    
    // 获取用户总数
    Integer getUserTotalCount();
    
    
    //用户
    List<UserCourseProgressDTO> selectProgressWithFilters();
    
    
    //用户完成了多少视频
    List<Map<String, Object>> countCompletedCoursesByUser();
    
    
    List<UserCityDTO> getCityUserCount();
    
    
    List<UserAgeDTO> getAgeUserCount();
    
    
    List<DateUserCourseCountDTO> selectDateCourseAll();
    
    
    List<UserInfo> selectUserInfoAll(UserInfoSearch userInfoSearch);
    
    List<UserInfo> selectUserInfoAll2(UserInfoSearch userInfoSearch);
    
    
    List<UserInfo> lookFollower(Integer userId);
    
    List<UserInfo> lookFans(Integer userId);
    
    List<UserScoreDTO> getScore(Integer userId, Integer communityId);

    Integer userFollow(Integer userId, Integer followeeUserId);
    
    List<Course> getCourseView(Integer userId);
    
    List<Post> getPostView(Integer userId);
}