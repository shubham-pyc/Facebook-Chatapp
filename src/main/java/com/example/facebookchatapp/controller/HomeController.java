package com.example.facebookchatapp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import models.FacebookRequest;
import models.FacebookResponse;
import models.IConstans;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.send.Message;
import com.restfb.types.send.SendResponse;




@RestController
public class HomeController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String helloWorld() throws IOException{
		File file = new File("output.html");
		if(file.exists()){
			return readFile(file) +"\n this is the file";
		}
		return "file not exists";
	}
	public static String readFile(File file) throws IOException{
		return new String(Files.readAllBytes(file.toPath()));
	}

	
	@RequestMapping(value="/callback")
	public String sendResponse(@RequestBody FacebookRequest param) throws IOException{
	
		
		
		FacebookResponse response = new FacebookResponse();
		Message message = new Message("hello world from bot");
		String id = param.getEntry()[0].getMessaging()[0].getSender().getId();
		sendMessage(id,message);
		
		System.out.println("Success");
		
		
		
		return null;
	}
	
	public static void sendMessage(String id,Message message) throws IOException{
		String uri = IConstans.FACEBOOK_URI + IConstans.TOKEN;
		FacebookClient pageClient = new DefaultFacebookClient(IConstans.TOKEN,Version.VERSION_2_9);
		SendResponse  response =  pageClient.publish("me/messages", SendResponse.class,
				Parameter.with("recipient", id),
					Parameter.with("message", message) );
		
	}

}
