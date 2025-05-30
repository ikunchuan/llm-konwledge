package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.entity.AdminLoginLog;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.mapper.AdminLoginLogMapper;
import com.llm.llm_knowledge.mapper.UserAdminInfoMapper;
import com.llm.llm_knowledge.service.UserAdminInfoService;
import com.llm.llm_knowledge.vo.LoginLogSearch;
import com.llm.llm_knowledge.vo.UserAdminInfoVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class UserAdminInfoServiceImpl implements UserAdminInfoService {

    @Autowired
    private UserAdminInfoMapper userAdminInfoMapper;

    @Override
    public UserAdminInfo login(UserAdminInfo userAdminInfo) throws UserException {
        QueryWrapper<UserAdminInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userAdminInfo.getUserName());
        String md5 = DigestUtils.md5Hex(userAdminInfo.getPassword());
        queryWrapper.eq("password", md5);
        UserAdminInfo userAdminInfoFromDB = userAdminInfoMapper.selectOne(queryWrapper);
        // 如果用户名或密码错误，抛出异常
        if (null == userAdminInfoFromDB) {
            throw new UserException("用户名或密码错误");
        }
        return userAdminInfoFromDB;
    }


    @Override
    public Integer register(UserAdminInfo userAdminInfo) throws UserException {
        // 判断用户名是否存在
        QueryWrapper<UserAdminInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userAdminInfo.getUserName());
        Long count = userAdminInfoMapper.selectCount(queryWrapper);
        // 这里同时考虑了两种情况：1.存在一个用户 2.或者存在多个用户
        if (1 <= count) {
            throw new UserException("用户已存在");
        }
        //对用户的密码进行加密
        String md5 = DigestUtils.md5Hex(userAdminInfo.getPassword());
        //把用户名和密码放到创建userAdminInfo里面
        userAdminInfo.setPassword(md5);
        //调用userAdminInfoService里面的方法
        return userAdminInfoMapper.insert(userAdminInfo);
    }
    
    
    //管理员用户登录后执行这个方法,记录登录日志
    @Override
    public void recordLoginLog(UserAdminInfoVO userAdminInfoVO) {
        userAdminInfoVO.setPassword(DigestUtils.md5Hex(userAdminInfoVO.getPassword()));
        userAdminInfoMapper.recordLoginLog(userAdminInfoVO);
    }
    
    @Override
    public PageInfo<AdminLoginLog> getAdminLoginLog(LoginLogSearch loginLogSearch,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AdminLoginLog> adminInfos = userAdminInfoMapper.selectLoginLogWithSearch(loginLogSearch);
        return new PageInfo<>(adminInfos);
    }
    
    
}