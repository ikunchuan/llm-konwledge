package com.llm.llm_knowledge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = "com.llm.llm_knowledge.mapper")
@MapperScan(basePackages = "com.llm.llm_knowledge.mapper")
public class LlmKnowledgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlmKnowledgeApplication.class, args);
	}

}


