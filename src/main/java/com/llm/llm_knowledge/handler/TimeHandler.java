package com.llm.llm_knowledge.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j  //日志输出的注解
@Component  //SpringBoot的组件注解
public class TimeHandler implements MetaObjectHandler {
    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert info");
//        setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
//        this.setFieldValByName("deleted",0,metaObject);
        this.setFieldValByName("createdTime",new Date(),metaObject);
        this.setFieldValByName("updatedTime",new Date(),metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update info");
        this.setFieldValByName("updatedTime",new Date(),metaObject);
    }
}
