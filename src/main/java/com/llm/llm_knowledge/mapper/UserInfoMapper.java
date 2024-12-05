package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
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
}