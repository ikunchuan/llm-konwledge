package com.llm.llm_knowledge.service.impl;

import com.llm.llm_knowledge.entity.AdminLoginLog;
import com.llm.llm_knowledge.repository.AdminLoginLogRepository;
import com.llm.llm_knowledge.service.AdminLoginLogService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class AdminLoginLogServiceImpl implements AdminLoginLogService {
    
    @Autowired
    private AdminLoginLogRepository adminLoginLogRepository;
    
    //用户登录时,
    public void logAdminLogin(String username, String password) {
        AdminLoginLog log = new AdminLoginLog();
        log.setUserName(username);
        String md5 = DigestUtils.md5Hex(password);
        log.setPassword(md5);
        log.setLoginTime(LocalDateTime.now());
        
        adminLoginLogRepository.save(log);
    }
    
}
