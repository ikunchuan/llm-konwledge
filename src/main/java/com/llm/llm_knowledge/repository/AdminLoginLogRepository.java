package com.llm.llm_knowledge.repository;

import com.llm.llm_knowledge.entity.AdminLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AdminLoginLogRepository extends JpaRepository<AdminLoginLog, Integer> {


}
