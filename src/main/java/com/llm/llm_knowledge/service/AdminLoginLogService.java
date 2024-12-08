package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.AdminLoginLog;

public interface AdminLoginLogService {
    
    void logAdminLogin(Integer loginboard, String userName, String password);

//     static Page<AdminLoginLog> findPage(Integer current, Integer size){
//         Page<AdminLoginLog> page = new Page<>(current, size);
//         return page;
//     };
}
