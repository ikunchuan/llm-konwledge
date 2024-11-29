package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserAdminInfoMapper extends BaseMapper<UserAdminInfo> {

}
