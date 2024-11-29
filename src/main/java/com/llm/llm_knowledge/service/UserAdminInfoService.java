package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserAdminInfoService extends IService<UserAdminInfo> {
}
