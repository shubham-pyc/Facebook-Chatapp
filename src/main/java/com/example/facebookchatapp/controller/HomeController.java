package com.example.facebookchatapp.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String helloWorld(){
		return "This is the new update";
	}
	
	@RequestMapping(value="/callback",method=RequestMethod.GET)
	
	public String firstUpdate(@RequestParam Map<String,String> allRequestParams){
		System.out.println(allRequestParams);
		return allRequestParams.toString();
	}
	

}
