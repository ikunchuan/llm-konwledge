package com.llm.llm_knowledge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.llm.llm_knowledge.mapper")
@SpringBootApplication
public class LlmKnowledgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlmKnowledgeApplication.class, args);
	}

}


