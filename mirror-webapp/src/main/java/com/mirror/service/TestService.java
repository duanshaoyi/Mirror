package com.mirror.service;

import java.util.List;

import com.mirror.entity.User.User;


public interface TestService {

	public List<User> getEmailByUserName(String userName);
	
	public String getUserEmailByWork(String title);
}
