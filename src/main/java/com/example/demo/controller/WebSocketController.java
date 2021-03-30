package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import com.example.demo.model.ChatRoom;
import com.example.demo.service.IChatRoomService;
import com.example.demo.service.IMessageService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    IUserService userService;

    @Autowired
    IMessageService messageService;
    @Autowired
    IChatRoomService chatRoomService;
    
    @MessageMapping("/send/message/{chatRoomId}")
    public ChatMessage sendMessageTo(@Payload ChatMessage chatMessage, @DestinationVariable("chatRoomId") Long chatRoomId){
        System.out.println(chatMessage);
        ChatRoom chatRoom;
        if (chatRoomService.findById(chatRoomId).isPresent()) {
            chatRoom = chatRoomService.findById(chatRoomId).get();
            this.template.convertAndSend(chatRoom.getName(), chatMessage);
            messageService.save(chatMessage);
        }
        return chatMessage;
    }


}
