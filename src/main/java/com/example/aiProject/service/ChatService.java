package com.example.aiProject.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.StreamingChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private StreamingChatModel streamingChatModel;


    public String getChatResponse(String prompt) {
        return chatModel.call(prompt);
    }

    public Flux<String> getStreamResponse(String prompt) {
        Flux<String> response = chatModel.stream(prompt);
        return response;
    }
}
