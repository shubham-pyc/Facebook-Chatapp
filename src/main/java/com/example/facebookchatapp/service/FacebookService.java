package com.example.facebookchatapp.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.facebookchatapp.models.IConstans;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.send.IdMessageRecipient;
import com.restfb.types.send.Message;
import com.restfb.types.send.SendResponse;


@Service
public class FacebookService {
	public static void sendMessage(String id,String messageText) throws IOException{
		Message message = new Message(messageText);
		try{
		IdMessageRecipient recipent = new IdMessageRecipient(id);
		String uri = IConstans.FACEBOOK_URI + IConstans.TOKEN;
		FacebookClient pageClient = new DefaultFacebookClient(IConstans.TOKEN,Version.VERSION_2_6);
		SendResponse  response =  pageClient.publish("me/messages", SendResponse.class,
				Parameter.with("recipient", recipent),
					Parameter.with("message", message) );
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
