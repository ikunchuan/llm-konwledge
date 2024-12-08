package com.llm.llm_knowledge.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationShutdownListener implements ApplicationListener<ContextClosedEvent> {
    
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        // 在这里添加资源释放的逻辑，例如关闭数据库连接、清理缓存等
        log.warn("正在释放资源...");
    }
}
