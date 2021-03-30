package com.example.demo.service;

import com.example.demo.model.ChatRoom;

import java.util.Optional;

public interface IChatRoomService extends IGenneralService<ChatRoom> {
    Optional<ChatRoom> getChatRoomByIds(Long firstUserId, Long secondUserId);
}
