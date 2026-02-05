package com.example.aiProject.controller;


import com.example.aiProject.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("chatWithGPT")
    private ResponseEntity<String> chatResponse(@RequestParam(value = "prompt") String prompt){
        String response = chatService.getChatResponse(prompt);
        return ResponseEntity.ok(response);
    }

    @GetMapping("streamResponse")
    private Flux<String> streamResponse(@RequestParam(value = "prompt") String prompt){
        Flux<String> response= chatService.getStreamResponse(prompt);
        return response;
    }

}
