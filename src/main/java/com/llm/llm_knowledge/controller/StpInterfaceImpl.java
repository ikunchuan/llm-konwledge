package com.llm.llm_knowledge.controller;

import cn.dev33.satoken.stp.StpInterface;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class StpInterfaceImpl implements StpInterface {
    
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        String sql = "SELECT p.promission_code FROM promission p " +
                "JOIN role_promission rp ON p.permission_id = rp.promission_id " +
                "JOIN role_user ur ON rp.role_id = ur.role_id " +
                "WHERE ur.user_id = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{loginId}, String.class);
    }
    
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        System.out.println("读取角色列表");
        List<String> list = new ArrayList<>();
        
        List<Map<String,Object>> maps = jdbcTemplate.queryForList("select distinct r.role_code from role_user ru , role r where ru.role_id = r.role_id and ru.user_id = ?",loginId);
        for (Map<String,Object> map : maps){
            list.add(map.get("role_code").toString());
        }
        
        return list;
    }
}
