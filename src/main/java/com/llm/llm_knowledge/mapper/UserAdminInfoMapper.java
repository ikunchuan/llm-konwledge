package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.entity.AdminLoginLog;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.vo.LoginLogSearch;
import com.llm.llm_knowledge.vo.UserAdminInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserAdminInfoMapper extends BaseMapper<UserAdminInfo> {
    
    void recordLoginLog(UserAdminInfoVO userAdminInfoVO);
    
    List<AdminLoginLog> selectLoginLogWithSearch(LoginLogSearch loginLogSearch);
}
