package com.example.facebookchatapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facebookchatapp.models.ChatMessage;
import com.example.facebookchatapp.models.FacebookRequest;
import com.example.facebookchatapp.models.FacebookResponse;
import com.example.facebookchatapp.service.UserAgentMapping;




@RestController
public class HomeController {
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@Autowired
	private UserAgentMapping userAgentMapping;
	
	
	@RequestMapping(value="/callback")
	public String sendResponse(@RequestBody FacebookRequest param) throws IOException{

		FacebookResponse response = new FacebookResponse();
		String message = new String("hello world from bot");
		String id = param.getEntry()[0].getMessaging()[0].getSender().getId();
		
		
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setSender(id);
		chatMessage.setMessage(param.getEntry()[0].getMessaging()[0].getMessage().getText());
		userAgentMapping.operate(chatMessage);
		
	
		//FacebookService.sendMessage(id,message);
		
		return null;
	}
	
	

}
