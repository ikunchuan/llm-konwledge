package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.*;
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
    @Select("SELECT user_sex AS user_sex, COUNT(*) AS count FROM user_info GROUP BY user_sex")
    List<Map<String, Object>> findUserSexDistribution();

    
    // 获取用户总数
    @Select("SELECT COUNT(*) AS total FROM user_info")
    int getUserTotalCount();
    
    
    List<UserCourseProgressDTO> selectProgressWithFilters();
    
    
    @Select("SELECT u.user_name, COUNT(*) AS completed_count " +
            "FROM course_progress cp " +
            "JOIN user_info u ON cp.user_id = u.user_id " +
            "WHERE cp.is_completed = 1 " +
            "GROUP BY u.user_name")
    List<Map<String, Object>> countCompletedCoursesByUser();
    
    
    @Select("SELECT user_local, COUNT(*) as `user_num` FROM user_info GROUP BY user_local")
    @Results({
            @Result(property = "userLocal", column = "user_local"),
            @Result(property = "userNum", column = "user_num")
    })
    List<UserCityDTO> getCityUserCount();
    
    
    @Select("SELECT user_age, COUNT(*) as age_count FROM user_info GROUP BY user_age")
    @Results({
            @Result(property = "userAge", column = "user_age"),
            @Result(property = "ageCount", column = "age_count")
    })
    List<UserAgeDTO> getAgeUserCount();
    
    
    List<DateUserCourseCountDTO> selectDateCourseAll();
    
    
    List<UserInfo> selectUserInfoAll(UserInfoSearch userInfoSearch);
    
    List<UserInfo> selectUserInfoAll2(UserInfoSearch userInfoSearch);
    
    
    List<UserInfo> lookFollower(Integer userId);
    
    List<UserInfo> lookFans(Integer userId);
    
    List<UserScoreDTO> getScore(Integer userId, Integer communityId);
}