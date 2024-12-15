package com.llm.llm_knowledge.controller;


import com.llm.llm_knowledge.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
@RequestMapping("chat")
public class OpenAiController {
    
    @Autowired
    private OpenAiService openAiService;
    
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream(@RequestParam String message) {
        SseEmitter emitter = new SseEmitter();
        try {
            // 假设streamResponse方法返回一个Flux<String>流式响应
            Flux<String> responseStream = openAiService.stream(message);
            responseStream.doOnTerminate(() -> {
                try {
                    emitter.complete();
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }
            }).subscribe(
                    messageData -> {
                        try {
                            emitter.send(messageData);
                        } catch (Exception e) {
                            emitter.completeWithError(e);
                        }
                    },
                    error -> emitter.completeWithError(error)
            );
        } catch (Exception e) {
            emitter.completeWithError(e);
        }
        return emitter;
    }
    
}
