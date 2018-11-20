package com.example.facebookchatapp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.facebookchatapp.models.Agent;
import com.example.facebookchatapp.service.AgentService;
@CrossOrigin(origins = "*")
@RestController
public class API {
	
	@RequestMapping(value="api/login")
	public ResponseEntity login(@RequestBody Agent user){
		
		System.out.println(user);
		if(AgentService.auth(user)){
			return new ResponseEntity(true,HttpStatus.OK);
		}
		return new ResponseEntity(true,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
