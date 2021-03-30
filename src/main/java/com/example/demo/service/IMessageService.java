package com.example.demo.service;

import com.example.demo.model.ChatMessage;

import java.util.List;

public interface IMessageService extends IGenneralService<ChatMessage>{
    List<ChatMessage> getChatMessageByChatRoom(Long chatRoomId);
}
