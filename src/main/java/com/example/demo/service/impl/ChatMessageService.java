package com.example.demo.service.impl;

import com.example.demo.model.ChatMessage;
import com.example.demo.repository.IMessageRepository;
import com.example.demo.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService implements IMessageService {
    @Autowired
    private IMessageRepository messageRepository;

    @Override
    public List<ChatMessage> getChatMessageByChatRoom(Long chatRoomId) {
        return messageRepository.getChatMessageByChatRoom(chatRoomId);
    }


    @Override
    public Iterable<ChatMessage> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<ChatMessage> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return messageRepository.save(chatMessage);
    }

    @Override
    public void remove(Long id) {
        messageRepository.deleteById(id);
    }
}
