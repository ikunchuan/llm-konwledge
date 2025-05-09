package com.llm.llm_knowledge.service.impl;

import com.llm.llm_knowledge.service.OpenAiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OpenAiServiceImpl implements OpenAiService {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Override
    public Flux<ChatResponse> stream(Prompt promptText) {
        return openAiChatModel.stream(promptText);
    }

}