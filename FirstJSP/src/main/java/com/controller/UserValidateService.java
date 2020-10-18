package com.controller;


public class UserValidateService{
	
	public boolean IsUserValid(String user,String password){
		if(user.equals(password)){
			return true;
		}
		return false;
	}
	
}