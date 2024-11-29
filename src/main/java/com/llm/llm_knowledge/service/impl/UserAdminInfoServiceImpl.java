package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.mapper.UserAdminInfoMapper;
import com.llm.llm_knowledge.service.UserAdminInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : symao
 */
@Service
@Transactional
public class UserAdminInfoServiceImpl implements UserAdminInfoService {

    @Autowired
    private UserAdminInfoMapper userAdminInfoMapper;

    @Override
    public UserAdminInfo findUserAdminInfo(UserAdminInfo userAdminInfo) throws UserException {
        QueryWrapper<UserAdminInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userAdminInfo.getUserName());
        String md5 = DigestUtils.md5Hex(userAdminInfo.getPassword());
        queryWrapper.eq("password", md5);
        // 这个地方只有两种情况：1.存在该用户。2.不存在该用户
        UserAdminInfo userAdminInfoFromDB = userAdminInfoMapper.selectOne(queryWrapper);
        // 如果用户名或密码错误，抛出异常
        if (null == userAdminInfoFromDB) {
            throw new UserException("用户名或密码错误");
        }
        return userAdminInfoFromDB;
    }

    /**
     * 插入用户信息
     *
     * @param userAdminInfo
     * @return
     */
    @Override
    public Integer addUserAdminInfo(UserAdminInfo userAdminInfo) {
        return userAdminInfoMapper.insert(userAdminInfo);
    }
}