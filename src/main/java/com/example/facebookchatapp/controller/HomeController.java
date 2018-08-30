package com.example.facebookchatapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String helloWorld(){
		return "This is the new update";
	}
	
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	public String firstUpdate(){
		return "this is something";
	}
	

}
