package com.example.demo.controller;

import com.example.demo.model.ChatRoom;
import com.example.demo.service.impl.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/{first_user_id}/{second_user_id}")
    public ChatRoom getRoomByIds(@PathVariable("first_user_id") long first_user_id, @PathVariable("second_user_id") long second_user_id) {
        Optional<ChatRoom> chatRoom = chatRoomService.getChatRoomByIds(first_user_id, second_user_id);
        if (chatRoom.isPresent()) {
            return chatRoomService.getChatRoomByIds(first_user_id, second_user_id).get();
        }
        return null;
    }
}
