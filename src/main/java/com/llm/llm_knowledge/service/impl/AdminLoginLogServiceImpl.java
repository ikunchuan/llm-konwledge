package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.AdminLoginLog;
import com.llm.llm_knowledge.entity.Question;
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
    public void logAdminLogin(Integer loginboard, String userName, String password) {
        AdminLoginLog log = new AdminLoginLog();
        log.setLoginboard(loginboard);
        log.setUserName(userName);
        String md5 = DigestUtils.md5Hex(password);
        log.setPassword(md5);
        log.setLoginTime(LocalDateTime.now());
        
        adminLoginLogRepository.save(log);
    }
//    @Override
//    public Page<AdminLoginLog> findPage(Integer current, Integer size) {
//        Page<AdminLoginLog> page = new Page<>(current, size);
//        return adminLoginLogRepository.selectPage(page, null); // 这里的 null 表示没有查询条件
//    }


//    public Page<AdminLoginLog> findPage(Integer pageNum, Integer pageSize) {
//        Page<AdminLoginLog> page = new Page<>(pageNum, pageSize);
//        Page<AdminLoginLog> pageVar = AdminLoginLogRepository.selectPage(page, null);
//        pageVar.getRecords().forEach(System.out::println);
//        return pageVar;
//    }
    
}
