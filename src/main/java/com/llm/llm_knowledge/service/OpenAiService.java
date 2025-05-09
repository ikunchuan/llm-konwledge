package com.llm.llm_knowledge.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface OpenAiService {
    Flux<ChatResponse> stream(Prompt prompt);
}