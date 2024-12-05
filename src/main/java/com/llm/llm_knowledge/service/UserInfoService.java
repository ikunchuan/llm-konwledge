package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.dto.UserCourseProgressDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.entity.UserInfo;
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

    //模糊查询社区
    IPage<UserInfo> uiByCondi(Integer userSex,String userName,Integer pageNum,Integer pageSize);
    
    
    List<UserCourseProgressDTO> progressDTO();
}

