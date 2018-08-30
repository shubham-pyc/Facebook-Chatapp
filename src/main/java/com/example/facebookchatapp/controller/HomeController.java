package com.example.facebookchatapp.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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
	public String sendResponse(@RequestParam Map<String,String> param) throws IOException{
	
		File file = new File("output.html");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(param.toString());
		fileWriter.flush();
		fileWriter.close();
		
	
		return null;
	}
	

}
