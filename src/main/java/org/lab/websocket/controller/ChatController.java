package org.lab.websocket.controller;

import org.lab.websocket.entities.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


import java.time.LocalDateTime;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        chatMessage.setTimestamp(LocalDateTime.now());
        System.out.println(chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        System.out.println(chatMessage.getContent());
        System.out.println(chatMessage.getSender());
        chatMessage.setContent("New user joined: " + chatMessage.getSender());
        return chatMessage;
    }


}
