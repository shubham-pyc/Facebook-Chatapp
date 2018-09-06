package com.example.facebookchatapp.websockets;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.example.facebookchatapp.models.ChatMessage;
import com.example.facebookchatapp.service.FacebookService;


@Controller
public class ChatController {
	
	@Autowired
	private FacebookService facebookService;
	@Autowired
	private SimpMessageSendingOperations templateMessage;
	
	@MessageMapping("/chat.addAgent")
	public void addUser(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor header){
		
		header.getSessionAttributes().put("username", chatMessage.getSender());
	}
	
	@MessageMapping("/chat.sendToUser")
	public void sendToUser(@Payload ChatMessage chatMessage) throws IOException{
		String username = chatMessage.getReceiver();
		String message = chatMessage.getMessage();
		
		facebookService.sendMessage(username, message);
		templateMessage.convertAndSendToUser(chatMessage.getSender(),"/reply",chatMessage);
		
	}
}
