package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import com.example.demo.service.impl.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/{id}")
    public List<ChatMessage> getChatMessages(@PathVariable Long id) {
        List<ChatMessage> list;
        try {
            list=chatMessageService.getChatMessageByChatRoom(id);
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
