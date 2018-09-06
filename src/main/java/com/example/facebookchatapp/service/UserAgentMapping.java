package com.example.facebookchatapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.example.facebookchatapp.models.ChatMessage;

@Service
public class UserAgentMapping {
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	
	public static Map<String,String> mapping = new HashMap<>();
	
	public  void operate(ChatMessage chatMessage){
		chatMessage.setReceiver("admin");
		chatMessage.setType(ChatMessage.MessageType.CHAT);
		System.out.println("sending message to admin/replys");
		
		messagingTemplate.convertAndSendToUser(chatMessage.getReceiver(),"/reply",chatMessage);
		
	}
	
	
}
