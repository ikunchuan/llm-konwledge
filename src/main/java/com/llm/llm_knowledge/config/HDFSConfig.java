package com.llm.llm_knowledge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HDFSConfig {
    @Bean
    public org.apache.hadoop.conf.Configuration hdfsConfig() {
        org.apache.hadoop.conf.Configuration config = new org.apache.hadoop.conf.Configuration();
        config.set("fs.defaultFS", "hdfs://10.8.0.1:9000");
        return config;
    }
}

