package com.example.facebookchatapp.service;

import java.util.ArrayList;
import java.util.List;

import com.example.facebookchatapp.models.Agent;

public class AgentService {
	
	private static AgentService service;
	
	private AgentService(){
		
	}
	public static AgentService getInstance(){
		if(service==null){
			service = new AgentService();
		}
		return service;
	}
	
	
	public static List<Agent> agents = new ArrayList();
	
	public static boolean auth(Agent user){
		if(user.getUsername().equals("admin") && user.getPassword().equals("password")){
			agents.add(user);
			return true;
		}else{
			return false;
		}
	}
	public static List getAgents(){
		return agents;
	}
}
