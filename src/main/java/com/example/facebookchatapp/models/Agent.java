package com.example.facebookchatapp.models;

import java.io.Serializable;

public class Agent implements Serializable {
	private String username;
	private String password;
	
	public Agent(){}
	
	public Agent(String username,String password){
		this.username = username;
		this.password = password;
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return "{ \"username \" :\""+username+"\",\"password\":\""+password+"\"}";
	}
	public boolean equals(Object object){
		if(object instanceof Agent){
			if(((Agent) object).username.equals(this.username) && ((Agent)object).password.equals( this.password)){
				return true;
			}
		}
		return false;
	}
	
}
