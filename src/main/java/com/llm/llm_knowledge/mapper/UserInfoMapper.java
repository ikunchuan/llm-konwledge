package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    // 自定义查询方法
}